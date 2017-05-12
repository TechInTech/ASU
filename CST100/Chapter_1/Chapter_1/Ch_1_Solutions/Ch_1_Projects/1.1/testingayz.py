"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/11/2014

Design a functions to print out prebuilt array
in Floyd indexing pattern.

"""
import math

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
