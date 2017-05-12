import turtle

def drawPoly(t, sd, sz):
    """Get turtle t to draw a square of sz side"""
    ang = (360.0/sd)
    
    for i in range(sd):
        t.forward(sz)
        t.left(ang)
        
def DrawEquilateral(t, sz):
    """Get turtle t to draw a square of sz side"""
    drawPoly(t,3,sz)

wn = turtle.Screen()
wn.bgcolor("lightblue")


alex = turtle.Turtle()
alex.color("red")

alex.penup()
alex.goto(-50,-50)
alex.pensize(2)
alex.pendown()
DrawEquilateral(alex,200)
alex.hideturtle()    

wn.exitonclick()
