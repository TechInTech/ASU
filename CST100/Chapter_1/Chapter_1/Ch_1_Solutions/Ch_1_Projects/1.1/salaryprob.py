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
hourlywage = float(input("Enter your hourly wage: "))
totalreghour = float(input("Enter your regular hours: "))
totalothours = float(input("Enter your total OT hours: "))

# Compute the results, declare varname and compute on the fly
regpay = hourlywage * totalreghour
otpay = (1.5 * hourlywage) * totalothours
totalweeklypay = regpay + otpay
totalregularannual = regpay * 48

# Display the results
print("Regular pay      : $",regpay)
print("OT Pay           : $",otpay)
print("Total Weekly pay : $",totalweeklypay)
print("Total Yearly pay : $",totalregularannual)
