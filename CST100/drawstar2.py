import turtle

def drawFivePointStar(t):
    for i in range(5):
        t.forward(100)
        t.left(216)

def starAdjust(t):
    t.penup()
    t.forward(350)
    t.right(144)
    t.pendown()

        
wn=turtle.Screen()
wn.bgcolor("lightblue")

wolfram = turtle.Turtle()
wolfram.color("black","white")
wolfram.penup()
wolfram.goto(-200,0)
wolfram.pendown()
drawFivePointStar(wolfram)

for i in range(4):
    wolfram.pendown()
    starAdjust(wolfram)
    drawFivePointStar(wolfram)



wn.exitonclick()

