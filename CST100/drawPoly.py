import turtle

def drawPoly(t, sd, sz):
    """Get turtle t to draw a square of sz side"""
    ang = (360.0/sd)
    
    for i in range(sd):
        t.forward(sz)
        t.left(ang)
        
wn = turtle.Screen()
wn.bgcolor("lightblue")
ssz=50
alex = turtle.Turtle()
alex.color("red")

alex.penup()

alex.pensize(2)
alex.pendown()


drawPoly(alex,3,ssz)
    

wn.exitonclick()
