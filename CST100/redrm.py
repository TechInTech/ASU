import image    #module to handle image object

img = image.Image("luther.jpg")  #initialize image to a jpg file
newimg = image.EmptyImage(img.getWidth(),img.getHeight())  #Blank image
win = image.ImageWin()  #Image window creation

for col in range(img.getWidth()):  #columns
    for row in range(img.getHeight()):  #rows
       p = img.getPixel(col, row)  #pixel in row, colum grid coordinate

       newred = 0  #Set new red value to 0
       green = p.getGreen()  #Get the green from the picture's pixel
       blue = p.getBlue()  #Get the blue from the picture's pixel

       newpixel = image.Pixel(newred, green, blue)  #replace old red with new red

       newimg.setPixel(col, row, newpixel)  #replace old pixel with new pixel

newimg.draw(win)
win.exitonclick()
