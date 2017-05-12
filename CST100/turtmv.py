import random
import turtle

def moveRandom(wn, t):
    coin = random.randrange(0,2)
    if coin == 0:
        t.left(90)
    else:
        t.right(90)

    t.forward(50)

def areColliding(t1, t2):
    if t1.distance(t2) < 2:
        t1.setheading(-t1.heading())
        t2.setheading(-t2.heading())
        return True
    else:
        return False

def isInScreen(w,t):
    leftBound = - w.window_width()/2
    rightBound = w.window_width()/2
    topBound = w.window_height()/2
    bottomBound = -w.window_height()/2

    turtleX = t.xcor()
    turtleY = t.ycor()

    stillIn = True
    
    if turtleX > rightBound or turtleX < leftBound:
        stillIn = False
    else:
        t.setheading(-t.heading())
        
    if turtleY > topBound or turtleY < bottomBound:
        stillIn = False
    else:
        t.setheading(-t.heading())
    
    return stillIn

t1 = turtle.Turtle()
t2 = turtle.Turtle()
wn = turtle.Screen()
wn.bgcolor("lightblue")

t1.shape('turtle')
t2.shape('arrow')

leftBound = int(-wn.window_width()/2)
rightBound = int(wn.window_width()/2)
topBound = int(wn.window_height()/2)
bottomBound = int(-wn.window_height()/2)

t1.up()
t1.goto(random.randrange(leftBound,rightBound),random.randrange(bottomBound,topBound))
t1.setheading(random.randrange(0,360))
t1.down()

t2.up()
t2.goto(random.randrange(leftBound,rightBound),random.randrange(bottomBound,topBound))
t2.setheading(random.randrange(0,360))
t2.down()


while isInScreen(wn,t1) and isInScreen(wn,t2):
    moveRandom(wn, t1)
    moveRandom(wn, t2)

wn.exitonclick()
