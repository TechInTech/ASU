"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 10/16/2014

Given height, top, and bottom lengths from user inputs,
compute the trapezoidal area.

Useful facts:
   A = (0.50) * (x1 + x2) * h
   where A is the computed area, x1, x2 are top and
   bottom lengths, and  h is the height.
   

"""

# include math library object for math operations.
import math
               
# Request the input => varname = float(input("message: "))
print("\nArea of a trapezoid")
height = float(input("Enter the height of the trapezoid: "))
x1 = float(input("Enter the length of the bottom base: "))
x2 = float(input("Enter the length of the top base: "))

# Compute the results, declare varname and compute on the fly
area = (0.50) * (x1 + x2) * height

# Display the results
print("The area is: ", area)

