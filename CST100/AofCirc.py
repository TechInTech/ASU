from test import testEqual
import math

def areaOfCircle(r):    
    return (math.pi * (r ** 2))

t = areaOfCircle(0)
testEqual(t,0)
t = areaOfCircle(1)
testEqual(t,math.pi)
t = areaOfCircle(100)
testEqual(t,(math.pi * (100 ** 2)))
