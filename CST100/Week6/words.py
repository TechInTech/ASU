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

Attempts were made to duplicate as close to the given output format as possible

"""


import string #Just in case I need to use any of the built-in methods

def find_longest_word(wordList): #Function to find the longest word
    """ Function to find longest word from a list. """
    wl2 = wordList #Duplicate from value passed in
    val = [len(wl2[i]) for i in range(len(wl2))] #List comprehensions
    #Building a list of length for postprocessing
    lstr = ' ' #Need this to maintain printing format
    pos = 0 #position of longest word
    for i in val: #I like for loop to loop about the length list
        if (i == max(val)): #the first event max length detected
            lstr = str(wl2[pos]) #Transfer string at detected position          
            break #Bail out of loop
        else: #Not at max length yet
            pos += 1 #Increment position variable

    print("\nThe longest word in the list is:\n") #Done, now print out
    print(lstr) #This way to conform with required screen output

def GetUserString(): #Function to bring in user string
    wlist = str(input("Enter a few words and I will find the longest:\n\n"))
    return wlist #Return string list from user

wl = GetUserString() #Get the user input string
wls = [] #Have a blank list to hold the listified words
wls = wl.split() #Listified words go into wls list
print("\nThe list of words entered is:\n") #Display what user entered
print(wls) #Display it
find_longest_word(wls) #Now go figure the first instance of the longest word.






