import image

def double(oldimage):
    oldw = oldimage.getWidth()
    oldh = oldimage.getHeight()

    newim = image.EmptyImage(oldw*2, oldh*2)
    for row in range(oldh):
        for col in range(oldw):
            oldpixel = oldimage.getPixel(col,row)

            newim.setPixel((2*col),(2*row), (oldpixel))
            newim.setPixel((2*col+1), (2*row), (oldpixel))
            newim.setPixel((2*col), (2*row+1), (oldpixel))
            newim.setPixel((2*col+1), (2*row+1), (oldpixel))

    return newim

win = image.ImageWin()
img = image.Image("luther.jpg")

bigimg = double(img)
bigimg.draw(win)

win.exitonclick()
