"""
Author: Hieu Pham
ID: 0953-827
Section: B
Date: 10/16/2014

Given current time in 24 hour format
and hours to wait, set off the alarm
when time to wait is up.

Useful facts:
   A = (0.50) * (x1 + x2) * h
   where A is the computed area, x1, x2 are top and
   bottom lengths, and  h is the height.
   

"""

# include math library object for math operations.
import math

clock = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]

def ampminput(): # Function to check for AM or PM
    ampmcheck = int(input("Enter 0 for AM and 1 for PM: "))
    if (ampmcheck < 0) or (ampmcheck > 1) :
        print("Must be either 0 or 1")
        ampminput()
    else:
        return ampmcheck

# Request the input => varname = float(input("message: "))
print("\nAlarm program")
currentTime = int(input("Enter the current time now: "))
daynight=ampminput()

if (daynight == 0) :
    formattedTime = currentTime
else :
    formattedTime = 12 + currentTime

timeToWait = int(input("Enter number of wait hours: "))

if (timeToWait <= 24) : # processing wait time within 24 hours
    alarmTime = (timeToWait + formattedTime) - 24
    print("The alarm goes off at:",(clock[alarmTime]*100)," hour today.")
else :
    nDay  = ((formattedTime + timeToWait) // 24)
    nHour = ((formattedTime + timeToWait) % 24)
    print("The alarm goes off at:",(clock[nHour]*100)," hour", nDay, " days from now.")



