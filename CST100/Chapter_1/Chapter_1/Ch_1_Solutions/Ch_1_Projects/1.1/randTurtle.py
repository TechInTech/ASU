import random
import turtle


#def isInScreen(w,t):
    #if random.random() > 0.1:
        #return True
    #else:
        #return False

def isInScreen(wn,t):
    leftBound = -(wn.window_width()/2)
    rightBound = wn.window_width()/2
    topBound = wn.window_height()/2
    bottomBound = -(wn.window_height()/2)

    turtleX = t.xcor()
    turtleY = t.ycor()

    stillIn = True
    if turtleX > rightBound or turtleX < leftBound:
        stillIn = False
    if turtleY > topBound or turtleY < bottomBound:
        stillIn = False

    return stillIn

t = turtle.Turtle()
wn = turtle.Screen()

t.shape('turtle')

while isInScreen(wn,t):
    coin = random.randrange(0,2)
    if coin == 0:              # heads
        t.left(90)
    else:                      # tails
        t.right(90)

    t.forward(50)
print("Done.")
wn.exitonclick()
