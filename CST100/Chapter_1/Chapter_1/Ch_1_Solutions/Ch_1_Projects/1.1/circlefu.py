import turtle
import math

def drawThreeCircles(turtle,ofs,rad):
    turtle.color('black', 'white')     #give mao turtle black trace and white fill
    turtle.speed(0)                    #give mao turtle maximum speed
    
    turtle.showturtle()
    
    turtle.pensize(3)
    turtle.penup()
    turtle.goto(0,ofs)
    turtle.pendown()
    turtle.begin_fill()
    for i1 in range(0,361):
        turtle.forward((2.0 * math.pi * rad) / 360.0)
        turtle.right(1.0)
    
    turtle.end_fill()
    turtle.hideturtle()

wn=turtle.Screen()              #Setup the screen using the Screen() function in turtle module
wn.bgcolor('blue')              #Assign background color of blue to the screen window

mao = turtle.Turtle()           #Instantiate a turtle name mao
drawThreeCircles(mao,-100,100)
drawThreeCircles(mao,40,70)
drawThreeCircles(mao,120,40)
wn.exitonclick()
