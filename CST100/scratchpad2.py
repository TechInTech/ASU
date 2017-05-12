# include math library object for math operations.
import math
import turtle


def MakeCircle(turtle,offset,radius):
    turtle.begin_fill()
    for i1 in range(0,361):
        turtle.penup()
        turtle.goto(0,offset)
        turtle.pendown()
        turtle.forward((2.0 * math.pi * radius) / 360.0)
        turtle.right(1.0)
        turtle.end_fill()


wn=turtle.Screen()
wn.bgcolor('blue')

mao = turtle.Turtle()
mao.color('black', 'white')
mao.pensize(3)
mao.penup()
mao.goto(0,-100)
mao.pendown()

mao.begin_fill()

for i1 in range(0,361):
    mao.forward((2.0 * math.pi * 100) / 360.0)
    mao.right(1.0)    

mao.penup()
mao.goto(0,40)


for i1 in range(0,361):
    mao.pendown()
    mao.forward((2.0 * math.pi * 70) / 360.0)
    mao.right(1.0)
    

mao.penup()
mao.goto(0,120)
mao.pendown()




wn.exitonclick()
