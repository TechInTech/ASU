import image

def smooth(oldimage):
    oldw = oldimage.getWidth()
    oldh = oldimage.getHeight()

    newim = image.EmptyImage(oldw, oldh)
    for row in range(oldh):
        for col in range(oldw):
            p1 = oldimage.getPixel(col, row)
            p2 = oldimage.getPixel(col+1, row)

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
            newim.setPixel(col, row, newPixel)
            
            #oldpixel = oldimage.getPixel(col,row)

            #newim.setPixel((2*col),(2*row), (oldpixel))
            #newim.setPixel((2*col+1), (2*row), (oldpixel))
            #newim.setPixel((2*col), (2*row+1), (oldpixel))
            #newim.setPixel((2*col+1), (2*row+1), (oldpixel))

    return newim

win = image.ImageWin()
img = image.Image("luther.jpg")

bigimg = smooth(img)
bigimg.draw(win)

win.exitonclick()
