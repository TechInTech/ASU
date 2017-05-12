import turtle

def drawPretty(t, sz):
    """Get turtle t to draw a square of sz side"""   
    #for i in range(sd):
    t.forward(sz)   #Straight out
    t.right(90)    #Turn right 90°
    t.forward(sz)   #Straight down
    t.right(90)    #Turn right 90°
    t.forward(2*sz)   #Straight bottom, 2x
    t.right(90)    #Turn right 90°
    t.forward(2*sz)   #Straight left, 2x
    t.right(90)    #Turn right 90°
    t.forward(2*sz)   #Straight top, 2x
    t.right(90)    #Turn right 90°
    t.forward(sz)   #Straight down, 1x
    t.home()
        
        
wn = turtle.Screen()
wn.bgcolor("lightblue")

alex = turtle.Turtle()
alex.color("blue")
alex.pensize(2)

numbsqr = 20
ang = 0.0

for b in range(numbsqr):
    #drawPretty(alex,80)
    alex.penup()
    alex.right(b*(360.0 / numbsqr))
    alex.pendown()
    drawPretty(alex,80)
    
alex.hideturtle()
wn.exitonclick()
