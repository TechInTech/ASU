import turtle

def drawStar(t, n):
    for i in range(n):
        t.forward(100)
        t.left(180 - (180/n))

wn=turtle.Screen()
wn.bgcolor("lightblue")

stroustrup = turtle.Turtle()
drawStar(stroustrup, 5)


wn.exitonclick()
