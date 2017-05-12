"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 10/16/2014

Given the user input in Fahrenheit, convert the user input to Celsius degrees.

Useful facts:
   C = (5.0/9.0) * (F - 32)
   where C is the temperature in Celsius and
   F is the temperature in Fahrenheit
   

"""

# include math library object for math operations.
import math
               
# Request the input => varname = float(input("message: "))
fahrenheit = float(input("Enter temperature in Fahrenheit: "))  

# Compute the results, declare varname and compute on the fly
celsius = (5.0/9.0) * (fahrenheit - 32)

# Display the results
print("\nThe temperature in Celsius: ", celsius)

