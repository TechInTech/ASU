import image

def convertSepia(input_image):
    sepia_image = image.EmptyImage(input_image.getWidth(),input_image.getHeight())

    for col in range(input_image.getWidth()):
        for row in range(input_image.getHeight()):
            p = input_image.getPixel(col, row)

            red = p.getRed()
            green = p.getGreen()
            blue = p.getBlue()
            
            newR = int((red * 0.393) + (green * 0.769) + (blue * 0.189))
            newG = int((red * 0.349) + (green * 0.686) + (blue * 0.168))
            newB = int((red * 0.272) + (green * 0.534) + (blue * 0.131))
            
            avg = int((red + green + blue) / 3.0)

            newpixel = image.Pixel(newR, newG, newB)
            sepia_image.setPixel(col, row, newpixel)

    #blackwhite_image = image.EmptyImage(input_image.getWidth(),input_image.getHeight())
    #for col in range(input_image.getWidth()):
        #for row in range(input_image.getHeight()):
            #p = grayscale_image.getPixel(col, row)
            #red = p.getRed()
            #if red > 140:
                #val = 255  #White
            #else:
                #val = 0  #Black

            #newpixel = image.Pixel(val, val, val)
            #blackwhite_image.setPixel(col, row, newpixel)
    return sepia_image


win = image.ImageWin()
img = image.Image("luther.jpg")

bw_img = convertSepia(img)
bw_img.draw(win)

win.exitonclick()
