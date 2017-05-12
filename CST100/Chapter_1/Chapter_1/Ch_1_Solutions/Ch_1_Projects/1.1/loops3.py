"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to concatenate digits
and then print out  in descending order following an
up-side-down isosceles triangle pattern

"""


import string  #Potential need for string functions


def printout1(x):  #Build a string of digits and spaces
    y2 = '' #Place holder for summing pattern
    for y in range(x):   #Digits based on given input x     
        y2 = y2 + str(y) + ' '     #summing pattern       
           
    return y2   #return constructed string to caller

xs = 10   #initialize xs to 10

for i in range(10): #loop to add leading spaces to strings
    yz = printout1(xs)  #build the string in reducing order
    yz = ((' ' * i) + yz)   #Add leading white spaces
    print(yz)   #print out to screen
    print("\n") #Give a new line on screen
    xs -= 1     #reduce xs to create isosceles triangle effect

    

