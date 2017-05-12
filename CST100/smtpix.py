import image
#image provided in tutorial
img = image.Image("luther.jpg")
win = image.ImageWin()
factor = 0.5

#resize the image
def resize(img, factor):
    W = img.getWidth()
    H = img.getHeight()

    newW = int(W * factor)
    newH = int(H * factor)

    newImage = image.EmptyImage(newW, newH)

    for col in range(newW):
        for row in range (newH):
            p = img.getPixel(col, row)
            newImage.setPixel(col * factor, row * factor, p)

    newImage.draw(win)
    img = newImage
    
    return img

#smooth out the image

def smooth(img):
    newImage = image.EmptyImage(img.getWidth(), img.getHeight())
    for col in range(img.getWidth()):
        for row in range(img.getHeight()):
            p1 = img.getPixel(col, row)
            p2 = img.getPixel(col+1, row)
            red1 = p1.getRed()
            red2 = p2.getRed()
            green1 = p1.getGreen()
            green2 = p2.getGreen()
            blue1 = p1.getBlue()
            blue2 = p2.getBlue()
            newRed = int((red1 + red2)/2)
            newGreen = int((green1 + green2)/2)
            newBlue = int((blue1 + blue2)/2)
            newPixel = image.Pixel(newRed, newGreen, newBlue)
            newImage.setPixel(col, row, newPixel)
            
    newImage.draw(win)
    return newImage

smallimg = smooth(img)
smallimg.draw(win)
win.exitonclick()
