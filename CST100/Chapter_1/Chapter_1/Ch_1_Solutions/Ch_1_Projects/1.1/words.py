"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/24/2014

Design a function "find_longest_word(wordList)".
that takes a list of words and returns the longest word
in the list. If there are multiple longest words (i.e., with the same length),
then it should return the first one among them (i.e., the one that appears
before others in the list).

Write a program that asks the user to enter some words separated by space
(all in one line). Your program then should create a list with the words
entered (you can use the built-in split method in strings for this)
and output the list and the longest word (using the above function).
Part 1
"""


import string

def find_longest_word(wordList):
    """ Function to find longest word from a list. """
    wl2 = wordList
    val = [len(wl2[i]) for i in range(len(wl2))]
    pos = 0
    for i in val:
        if (i == max(val)):
            print("The longest word in the list is:\n",wl2[pos])
            break
        else:
            pos += 1

def GetUserString():
    wlist = str(input("Enter a few words and I will find the longest: "))
    return wlist

wl = GetUserString()
wls = []
wls = wl.split()
print("The list of words entered is:\n",wls)
find_longest_word(wls)






