"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to print
10 lines of decimal numbers, from 0 to 9, on each line.

"""
import math
from itertools import count

def floyd(n):
     count = 1
     string = ""
     for i in range(1,n+2):
          for j in range(1,i):
              string = string + " " + str(count)
              count = count + 1
          print(string)
          string = ""



def floyd2(n):
    x = ((n**2 + n)//2)
    last_row = ' '.join(str(s) for s in range(x-(n-1), x+1))
    width = len(last_row)
    c = count(1)
    for x in range(1, n):
        line = ' '.join(str(next(c)) for _ in range(x))
        print("{:^{}}".format(line, width))
    print(last_row)

def trianglenumbers(xs):  
    return [(n*(n+1)//2) for n in range(xs)] 

def generatenumbers(mn,mx):
    
    return [(n+10) for n in range(mn,(mx),1)]

def repacknumbers(numblist,size):
    nnl = []  #Create a list
    for n in range(size):
        nnl.append(numblist[n])

    return nnl

def printstringtp(arrlist,xs):    #Printing function
    """ Use 1 variable to pass into the function for robustness.
        Print the digits in a right triangle pattern
    """
    for x in range(xs+1): #Outer loop for line iteration
        print("\n")
        z=0
        for y in range(x):
            #print(arrlist[z],end=' ')
            z = y + 1
            
    
a = trianglenumbers(11)
maxnumb = (max(a) - 1)
minnumb = min(a)
b = generatenumbers(minnumb,maxnumb)
c = repacknumbers(b,45)
d = len(c)
printstringtp(c, d)
print("\n")
floyd(9)     
