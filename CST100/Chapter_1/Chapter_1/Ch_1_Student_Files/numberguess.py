"""
Author: Ken Lambert
Plays a game of guess the number with the user.
"""

import random  # similar to include directive in C

def main():  # unlike C, function in Python starts with def, function, :
    """Inputs the bounds of the range of numbers,
    and lets the user guess the computer's number until
    the guess is correct."""
    smaller = int(input("Enter the smaller number: "))  # int() integerizes the variable
    larger = int(input("Enter the larger number: "))  # int() integerizes the variable
    myNumber = random.randint(smaller, larger)  # call randint() method from random object
    count = 0
    while True:  # similar to C, but use :
        count += 1
        userNumber = int(input("Enter your guess: "))
        if userNumber < myNumber:
            print("Too small")
        elif userNumber > myNumber:
            print("Too large")
        else:
            print("You've got it in", count, "tries!")
            break

if __name__ == "__main__":
    main()
