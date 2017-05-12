import turtle

def drawSquare(t, sz):
    """Get turtle t to draw a square of sz side"""
    for i in range(4):
        t.forward(sz)
        t.left(90)
        
wn = turtle.Screen()
wn.bgcolor("lightblue")
ssz=20
alex = turtle.Turtle()
alex.color("pink")

alex.penup()
alex.goto(-100,0)
alex.pensize(3)
alex.pendown()

for b in range(5):
    drawSquare(alex,ssz)
    alex.penup()
    alex.forward((2*ssz)+b)
    alex.pendown()


wn.exitonclick()
