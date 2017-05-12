import turtle
import math
import random

fred = turtle.Turtle()
insideCount = 0


wn = turtle.Screen()
wn.setworldcoordinates(-1,-1,1,1)

numdarts = 200
for i in range(numdarts):
    sgnx = random.choice('+-')
    sgny = random.choice('+-')
    randx = random.random()
    randy = random.random()
    
    if sgnx == '-':
        x = (-1.0 * randx)
    else:
        x = randx
        
    if sgny == '-':
        y = (-1.0 * randy)
    else:
        y = randy

    fred.up()
    fred.goto(x,y)
    fred.down()
    be = fred.distance(0,0)
    if (be <= 1.0):
        fred.dot(5,"red")
        fred.write(i+1)
        insideCount += 1
    else:
        fred.dot(5,"blue")
        fred.write(i+1)
    
    fred.up()

Py = (4.0 * (insideCount / numdarts))
print(Py)
fred.hideturtle()
wn.exitonclick()
