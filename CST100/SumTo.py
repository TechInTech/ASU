import math

def sumTo(n):
    """Get turtle t to draw a square of sz side"""
    return ((n*(n+1))/2.0)

nn = float(input("Enter a value to sum up: "))
Summs = sumTo(nn)
print("The sum from 1 up to ",nn, " is: ",Summs)
