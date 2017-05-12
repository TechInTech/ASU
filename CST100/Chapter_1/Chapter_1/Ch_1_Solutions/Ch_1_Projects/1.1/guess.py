"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 10/28/2014

Given the user input, compare to the randomly generated number.
Give the user 3 tries, print out the compared result each time.
If the user guessed correctly the first time, exit the program with
the result.   

"""

import math
import random

number = 10
numAttempts = 0
lowerbound = 1
upperbound = 20
uName = input("Hello! What's your name?\n")
print("Well, ",uName," I am thinking of a number between 1 and 20.")
number = random.randint(lowerbound,upperbound)

for i in range(4):
    numAttempts += 1
    guess = int(input("Take a guess. "))
    if guess < number:
        print("Your guess is too low")        
        if numAttempts >= 3:
            print("Your guess is too low. Your three guesses are over. The number I was thinking of was ",number)
            break    
    elif guess > number:
        print("Your guess is too high")
        if numAttempts >= 3:
            print("Your guess is too high. Your three guesses are over. The number I was thinking of was ",number)
            break
    else:
        print("Good job, ",uName,"! You guessed in ",numAttempts," guesses!")
        break

   
