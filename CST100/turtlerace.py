import turtle              # 1.  import the modules
import random
wn = turtle.Screen()       # 2.  Create a screen
wn.bgcolor('lightblue')

lance = turtle.Turtle()    # 3.  Create two turtles
andy = turtle.Turtle()
lance.color('red')
andy.color('blue')
lance.shape('turtle')
andy.shape('turtle')

andy.up()                  # 4.  Move the turtles to their starting point
lance.up()
andy.goto(-150,20)
lance.goto(-150,-20)


# your code goes here
for i in range(0,25,1):
    x = random.randrange(i,25)
    andy.forward(x)
    #andy.stamp()
    lance.forward(x)
    #lance.stamp()
    
wn.exitonclick()
