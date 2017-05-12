import math
import turtle
wn = turtle.Screen()
wn.bgcolor('lightblue')
fred = turtle.Turtle()
john = turtle.Turtle()
fred.goto(0,0)
fred.pendown()
john.goto(0,0)
john.pendown()
for x in range(0,361):
	y = 100.0 * math.sin(math.radians(x))
	z = 100.0 * math.cos(math.radians(x))
	# print("x = ",x," y = ",y)
	fred.goto(x,y)
	john.goto(x,z)

john.penup()
john.goto(0,0)

fred.goto(0,0)

fred.goto(0,100)
fred.penup()
fred.goto(0,0)
fred.pendown()
fred.goto(0,-100)
fred.penup()
fred.goto(0,0)

wn.exitonclick()

