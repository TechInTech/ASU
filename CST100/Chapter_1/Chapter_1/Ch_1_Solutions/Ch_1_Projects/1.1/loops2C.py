"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to print
10 lines of decimal numbers, from 0 to 9, on each line.

"""

def printstringtp(xs):    #Printing function
    """ Use 1 variable to pass into the function for robustness.
        Print the digits in a right triangle pattern
    """
    a = 0
    for x in range(xs,0,-1): #Outer loop for line iteration       
        for y in range(x):
            s1 = (' ' * a)
            y2 = str(y)
            y3 = (s1 + y2)
            print(y2,end=' ')            

        print("\n")
        a = a + 1    
                
printstringtp(10) #call the function, using a digit as an argument.
