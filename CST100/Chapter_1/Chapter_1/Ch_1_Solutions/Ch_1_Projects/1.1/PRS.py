"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 10/28/2014

Paper, Rock, Scissors (P(p), R9r), S(s))
Get inputs from 2 users. Available choices are P(p), R9r), S(s)
compute the outcome based on the rock, paper, scissors game.
Use function call to judge the outcome.
Possible outcomes: 1 = player 1 wins, 2 = player 2 wins, 3 = tie.
Repeat 5 times and tallies up scores.

Note: There is no checking for user input at this time to accept
correct values and reject bad user entries. Future revision.

"""

import math

def judging(p1,p2):
    if (p1 == 'P'):
        if (p2 == 'R'):
            return 1
        elif (p2 == 'S'):
            return 2
        elif (p2 == 'P'):
            return 3
    elif (p1 == 'R'):
        if (p2 == 'S'):
            return 1
        elif (p2 == 'P'):
            return 2
        elif (p2 == 'R'):
            return 3
    elif (p1 == 'S'):
        if (p2 == 'P'):
            return 1
        elif (p2 == 'R'):
            return 2
        elif (p2 == 'S'):
            return 3
            
tResult = 0            
pl1w = 0
pl2w = 0
plt = 0

for i in range(5):
    pl1 = input("Player 1: Please enter either (R)ock, (P)aper, or (S)cissors:").upper()
    pl2 = input("Player 2: Please enter either (R)ock, (P)aper, or (S)cissors:").upper()

    tResult = judging(pl1,pl2)

    if (tResult == 1):
        pl1w += 1
        print("Player ",tResult," wins.")
    elif (tResult == 2):
        pl2w += 1
        print("Player ",tResult," wins.")
    else:
        plt += 1
        print("Nobody wins.")

    print("Scores after this play:\n")
    print("Player 1: ",pl1w,"\n")
    print("Player 2: ",pl2w,"\n")
    print("Ties: ",plt,"\n")
    print("Thanks!!\n")

