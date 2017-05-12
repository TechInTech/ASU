import turtle

def drawPretty(t, sz, ns, ang,ofs):
    """Get turtle t to draw a square of sz side"""
    t.goto(ofs,0)
    t.pendown()
    for i in range(ns):
        t.right(ang)    #Turn right 90°
        t.forward((i+2) * sz)   #Straight out
    

def udrawPretty(t, sz, ns, ang,ofs):
    """Go draw pretty"""
    t.penup()
    t.showturtle()
    drawPretty(t,sz,ns,ang,ofs)
    t.right(90)        
        

wn = turtle.Screen()
wn.bgcolor("lightblue")

alex = turtle.Turtle()
alex.color("blue")
alex.pensize(1)

ale = turtle.Turtle()
ale.color("purple")
ale.pensize(1)
ale.hideturtle()

alex.penup()
udrawPretty(alex,2,103,90,-200)
ale.penup()
udrawPretty(ale,2,103,89,120)



wn.exitonclick()
