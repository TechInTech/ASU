"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to print
10 lines of decimal numbers, from 0 to 9, on each line.
Part 1
"""
import string  #Potential need for string functions
import math

def printstring(tn,xs):    #Printing function
    """ Use 2 variables to pass into the function for robustness.
        tn is the triggering number, tn = -1 will print all digits.
        otherwise, the lines will be whatever tn value is.
        xs is just 10 for now
    """
    if (tn > -1) and (tn <= 9):
        for x in range(xs): #Outer loop for line iteration
            print("\n")     #Need this new line to meet the output requirement
            for y in range(xs):     #Inner loop for horizontal printing
                print(tn,end=' ')   #User defined format, which is a
                                    #digit followed by a white space
    elif tn == -1:
        for x in range(xs): #Outer loop for line iteration
            print("\n")     #Need this new line to meet the output requirement
            for y in range(xs):     #Inner loop for horizontal printing
                print(y,end=' ')   #User defined format, which is a
                                    #digit followed by a white space
    else:
        print("Must be single digit, please!\n")
    
    
printstring(-1,10) #call the function, using a digit as an argument.

"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to print
10 lines of decimal numbers, from 0 to 9, on each line.
Part 2
"""

def printstringtp2(xs):    #Printing function
    """ Use 1 variable to pass into the function for robustness.
        Print the digits in a right triangle pattern
    """
    for x in range(xs+1): #Outer loop for line iteration
        print("\n")
        for y in range(x):
            print(y,end=' ')
                 
    
    
printstringtp2(10) #call the function, using a digit as an argument.

"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/10/2014

Design a function, using 2 loops, to concatenate digits
and then print out  in descending order following an
up-side-down isosceles triangle pattern

Part 3
"""

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
    
"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/11/2014

Design a functions to print out prebuilt array
in Floyd indexing pattern.

Part 4
"""

def floyd(nary,n):  #Function to print an array using Floyd's pattern
     count = 1      #Initialize forward count (Floyd pattern is 1, 2-3, 4-5-6     
     for i in range(1,n+2): #Outer loop goes from 1 to 10         
         for j in range(1,i): #Inner loop goes from 1 to i
             print(nary[count-1],end=' ') #Print out array at index 0            
             count = count + 1  #Increments count
         print("\n")    #Print it out
        

def trianglenumbers(xs): #Function to construct a triangular number array   
        return [(n*(n+1)//2) for n in range(xs)] 

def generatenumbers(mn,mx):  #Function to add 10 to existing triangular number array    
    return [(n+10) for n in range(mn,(mx),1)]

def repacknumbers(numblist,size): #Function to pack array from 10 on
    nnl = []  #Create a list
    for n in range(size):   #Only use numbers from 10 to 54, inclusive
        nnl.append(numblist[n]) #Build the new array

    return nnl   #Return it to caller
            
    
a = trianglenumbers(11)  #Create a triangular array of triangular numbers
maxnumb = (max(a) - 1)  #Get the max number from triangular number array
minnumb = min(a)    #Get the min number from triangular number array
b = generatenumbers(minnumb,maxnumb) #Generate new triangular number from 10 on
c = repacknumbers(b,45)  #Repack array into a printable one
d = len(c)  #Obtain the array size
floyd(c,9)  #Use the Floyd array indexing rule to print.  
