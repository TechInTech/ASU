"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 10/16/2014

In this assignment the programmer will use the `turtle` python module
to draw a snowman. The Turtle.circle method is not allowed to draw circles.

Snowman Requirements:

    The snowman should be on a blue background, and
    should be drawn filled with white.
    
    The outline of the snowman should be in black.
    
    The snowman’s body should be made of 3 filled circles.
    
    The outline of each circle should be 3 pixels wide.
    
    The bottom circle should have a radius of 100 pixels.
    
    The middle circle should have a radius of 70 pixels.
        
    The top circle should have a radius of 40 pixels.
    
    Each circle should be centered above the one below it
    except the bottom circle, which can be located anywhere).
    
    There should be no gap between the circles.
    Give the snowman a mouth, eyes, and a nose (a hat is optional).
    Make sure to include two stick-arms and at least two fingers on each hand.

Summary: Use the programmer's own algorithm to draw circles.
   

"""

# include some library modules for subsequent operations.
import math
import turtle


wn=turtle.Screen()              #Setup the screen using the Screen() function in turtle module
wn.bgcolor('blue')              #Assign background color of blue to the screen window

mao = turtle.Turtle()           #Instantiate a turtle name mao
mao.color('black', 'white')     #give mao turtle black trace and white fill
mao.speed(0)                    #give mao turtle maximum speed
mao1 = turtle.Turtle()          #Instantiate a turtle name mao1
mao1.color('black', 'white')    #give mao1 turtle black trace and white fill
mao1.speed(0)                   #give mao1 turtle maximum speed
mao2 = turtle.Turtle()          #Instantiate a turtle name mao2
mao2.color('black', 'white')    #give mao2 turtle black trace and white fill
mao2.speed(0)                   #give mao2 turtle maximum speed

mao.begin_fill()                #mao turtle task: fill the biggest circle with white
mao.pensize(3)                  #Draw the outline with tracewidth of 3 pixels
mao.penup()                     #lift the pen up
mao.goto(0,-100)                #move down 100 pixels to make room for other circles
mao.pendown()                   #put down the pen, ready to draw
mao1.hideturtle()
mao2.hideturtle()

for i1 in range(0,361):         #A 0 to 360 geometric degrees for loop
    mao.forward((2.0 * math.pi * 100) / 360.0)  #March towards the circumference point and draw in black
    mao.right(1.0)                              #Turn right 1° and draw in black 

mao.end_fill()                                  #Fill the circle in white when done
mao.hideturtle()
"""
mao1 turtle draws the middle circle with radius 70 pixels.
The algorithm is the same as mao turtle.
An offset of 40 pixels on y-axis is required to avoid gap.
"""
mao1.showturtle()
mao1.begin_fill()
mao1.pensize(3)
mao1.penup()
mao1.goto(0,40)
mao1.pendown()
for i1 in range(0,361):
    mao1.forward((2.0 * math.pi * 70) / 360.0)
    mao1.right(1.0)
    
mao1.end_fill()
mao1.hideturtle()
"""
mao2 turtle draws the top circle with radius 40 pixels.
The algorithm is the same as mao turtle.
An offset of 120 pixels on y-axis is required to avoid gap.
"""
mao2.showturtle()
mao2.begin_fill()
mao2.pensize(3)
mao2.penup()
mao2.goto(0,120)
mao2.pendown()

for i1 in range(0,361):
    mao2.forward((2.0 * math.pi * 40) / 360.0)
    mao2.right(1.0)
    
mao2.end_fill()

mao.penup()
mao.goto(-150,0)
mao.hideturtle()
mao1.penup()
mao1.goto(-150,0)
mao1.hideturtle()
mao2.penup()
mao2.goto(-150,0)
mao2.hideturtle()
#Retire mao, mao1, and mao2 turtles. Their jobs are done.

#Create cat turtle with black trace and red filling.
cat = turtle.Turtle()
cat.color('black', 'red')
cat.speed(0)                #cat turtle draws at maximum speed
cat.begin_fill()            #Mark the filling here
cat.pensize(3)              #Tracewidth is set to 3 pixels
cat.penup()                 #Lift the pen up
cat.goto(-15,90)            #Move to top circle, a little off to the left
cat.pendown()               #Stay there permanently
cat.end_fill()              #Give black trace filled in red for the left eye

"""
cat1 turtle draws the right eye.
It does so by moving to the top circle, off to the right.
It stays there, turning its sharp arrow point 180 degrees
to face the left arrow. It has black trace and red filling.
"""
cat1 = turtle.Turtle()
cat1.color('black', 'red')
cat1.speed(0)
cat1.begin_fill()
cat1.pensize(3)
cat1.penup()
cat1.goto(15,90)
cat1.left(90)   #Rotating to
cat1.left(90)   #180 degrees
cat1.pendown()
cat1.end_fill()

"""
cat2 turtle draws the nose.
It does so by creating a black dot 12 pixels wide,
right at somewhere near the center of the top circle.
"""
cat2 = turtle.Turtle()
cat2.color('black', 'red')
cat2.speed(0)
cat2.pensize(3)
cat2.penup()
cat2.goto(-2,82)
cat2.pendown()
cat2.dot(12)
cat2.hideturtle()

"""
cat3 turtle draws the mouth.
It does so by creating a rectangle in grey
somewhere near the bottom of the top circle.
The finished mouth is filled with brown
"""
cat3 = turtle.Turtle()
cat3.color('grey', 'brown')
cat3.speed(0)
cat3.begin_fill()
cat3.pensize(3)
cat3.penup()
cat3.goto(-10,65)
cat3.pendown()
cat3.forward(20)
cat3.right(90)
cat3.forward(10)
cat3.right(90)
cat3.forward(20)
cat3.right(90)
cat3.forward(10)
cat3.hideturtle()
cat3.end_fill()

"""
cat4 turtle draws the stick-arms with 3 fingers each.
It does so by simple goto, left, and right movements.
This is the left stick-arm
"""
cat4 = turtle.Turtle()
cat4.color('black', 'white')
cat4.speed(0)
cat4.begin_fill()
cat4.pensize(5)
cat4.penup()
cat4.goto(-40,0)
cat4.pendown()
cat4.left(90)
cat4.left(90)
cat4.forward(80)
cat4.pensize(2)
cat4.right(30)
cat4.forward(20)
cat4.left(90)
cat4.left(90)
cat4.forward(20)
cat4.right(30)
cat4.forward(20)
cat4.left(90)
cat4.left(90)
cat4.forward(20)
cat4.left(90)
cat4.forward(20)

"""
cat4 turtle draws the stick-arms with 3 fingers each.
It does so by simple goto, left, and right movements.
This is the right stick-arm
"""
cat4.pensize(5)
cat4.penup()
cat4.goto(40,0)
cat4.pendown()
cat4.right(90)
cat4.right(90)
cat4.forward(80)
cat4.pensize(2)
cat4.left(30)
cat4.forward(20)
cat4.right(90)
cat4.right(90)
cat4.forward(20)
cat4.left(30)
cat4.forward(20)
cat4.right(90)
cat4.right(90)
cat4.forward(20)
cat4.right(90)
cat4.forward(20)

"""
cat4 turtle also draws the snowman hat.
It does so by simple goto, left, and right movements.
"""
cat4.penup()
cat4.color('lightgreen', 'orange')
cat4.pensize(10)
cat4.goto(-80,120)
cat4.pendown()
cat4.forward(160)
cat4.penup()
cat4.pensize(6)
cat4.begin_fill()
cat4.goto(-50,120)
cat4.pendown()
cat4.left(30)
cat4.forward(60)
cat4.right(60)
cat4.forward(60)
cat4.hideturtle()
cat4.end_fill()

#Click the mouse to close the window
wn.exitonclick()
