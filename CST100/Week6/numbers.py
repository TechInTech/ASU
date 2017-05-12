"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/24/2014

Implement the following three functions (you should use an appropriate looping construct to compute the averages):

    allNumAvg(numList) : takes a list of numbers and returns the average of all the numbers in the list.
    posNumAvg(numList) : takes a list of numbers and returns the average of all the numbers in the list that are greater than zero.
    nonPosAvg(numList) : takes a list of numbers and returns the average of all the numbers in the list that are less than or equal to zero.


Write a program that asks the user to enter some numbers (positives, negatives and zeros). Your program should NOT ask the user to enter a fixed number of numbers. Also it should NOT ask for the number of numbers the user wants to enter. But rather it should ask the user to enter a few numbers and end with -9999 (a sentinel value). The user can enter the numbers in any order. Your program should NOT ask the user to enter the positive and the negative numbers separately.

Your program then should create a list with the numbers entered (make sure NOT to include the sentinel value (-9999) in this list) and output the list and a dictionary with the following Key-Value pairs (using the input list and the above functions):

    Key = 'AvgPositive'  :  Value = the average of all the positive numbers
    Key = 'AvgNonPos'  :  Value = the average of all the non-positive numbers
    Key = 'AvgAllNum'  :  Value = the average of all the numbers

"""


import string
import math

def GetUserInput(): #Function to get user entries
    """
        Function to get user entries.
        Integer values are signed values.
        Can be entered in any order, as specirfied.
        As long as value is not the sentinel value (-9999)
        just keep going. Otherwise, return values in list
        excluding sentinel value.
    """
    rawvals = [] #An empty list to hold all values entered    
    vals = 0 #Intermediate value entered    
    while vals != -9999: #Allow all integers not -9999
        vals = int(input("\nEnter a number (-9999 to end): ")) #Collect integers
        rawvals.append(vals) #Fill the list       
        
    rawvals.remove(-9999)#Remove the sentinel key 
    return rawvals #and return the ready-to-use list

def allNumAvg(numList):
    """
        Function that takes a list of numbers and returns
        the average of all the numbers in the list.
        This is the easiest function of all 3
    """
    return (sum(numList) / float(len(numList))) #Thanks to built-in functions
    
def posNumAvg(numList):
    """
        Function that takes a list of numbers and returns
        the average of all the numbers in the list that are greater
        than zero. This may require some transfering of elements
        from original list
    """
    
    pv = [] #An empty list

    for i in numList: #Iterating about the original list
        if i > 0: #If element is greater than 0
            pv.append(i) #Fill the list up
        else: #Otherwise,
            continue #Move on

    return (sum(pv) / float(len(pv))) #Thanks to built-in functions

def nonPosAvg(numList):
    """
        Function that takes a list of numbers and returns
        the average of all the numbers in the list that are less
        than or equal to zero.
    """
    pv = [] #An empty list

    for i in numList: #Iterating about the original list
        if i <= 0: #If element is less than or equals to 0
            pv.append(i) #Fill the list up
        else: #Otherwise,
            continue #Move on

    return (sum(pv) / float(len(pv)))#Thanks to built-in functions
    
def buildDictionary(ap,anp,aan):
    """
        Function to build and return a dictionary of computed
        average for all numbers, positive numbers, and non-positive
        numbers. The keys are as follows:
        
        Key = 'AvgPositive'  :  Value = the average of all the positive numbers
        Key = 'AvgNonPos'  :  Value = the average of all the non-positive numbers
        Key = 'AvgAllNum'  :  Value = the average of all the numbers

        Note: Dictionary pairs are unordered.
    """
    cValue = { } #A blank dictionary
    cValue["AvgPositive"] = ap #First pair is average all positive
    cValue["AvgNonPos"] = anp #Second pair is average all nonpositive
    cValue["AvgAllNum"] = aan #Third pair is average all list elements
    return cValue #return newly built dictionary to caller



rv = GetUserInput() #Get the mixed integer list
print("\nThe list of all numbers entered is:","\n")
print(rv,"\n") #Print it out

avg = allNumAvg(rv) #Compute the average of all elements in list
rpv = posNumAvg(rv) #Compute the average of only positive elements in list
rnpv = nonPosAvg(rv) #Compute the average of nonpositive elements in list
                     #including zero

cV = buildDictionary(rpv,rnpv,avg) #Build the dictionary
print(cV) #Print the dictionary out



