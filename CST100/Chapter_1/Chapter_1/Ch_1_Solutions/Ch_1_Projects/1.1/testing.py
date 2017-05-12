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
    for x in range(xs+1): #Outer loop for line iteration        
        print("\n")
        for y in range(x+1):
            z = int((0.5)*(y)*(y+1))
            print((z),end=" ")
            #print(z,end=' ')      
                 
    
    
printstringtp(10) #call the function, using a digit as an argument.
