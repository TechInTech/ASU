"""
Program: sphere.py
Project 1.1

Given the radius compute the diameter, circumference, and volume
of a sphere.

Useful facts:
   diameter = 2 * radius
   circumference = diameter * 3.14
   surface area = 4 * PI * radius * radius
   volume = 4/3 * PI * radius * radius * radius

"""

# include math library object for math operations.
import math
               
# Request the input => varname = float(input("message: "))
radius = float(input("Enter the sphere's radius: "))  

# Compute the results, declare varname and compute on the fly
diameter = 2 * radius
circumference = diameter * math.pi
surfaceArea = 4 * math.pi * radius * radius
volume = (4.0/3.0) * math.pi * (radius ** 3)

# Display the results
print("Diameter     :", diameter)
print("Circumference:", circumference)
print("Surface area :", surfaceArea)
print("Volume       :", volume)
