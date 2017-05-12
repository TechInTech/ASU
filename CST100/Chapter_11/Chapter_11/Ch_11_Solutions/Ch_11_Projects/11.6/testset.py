"""
File: testset.py

Project 11.6

A tester program for set implementations.
Prints the length of the set and its load factor before each addtion.
"""

#from arrayset import ArraySet
#from linkedset import LinkedSet
#from arraysortedset import ArraySortedSet
from hashset import HashSet

def test(setType):
    """Expects a set type as an argument and runs some tests
    on objects of that type."""
    s = setType()
    for i in range(100):
        print("Number of items before add:", len(s))
        print("Load factor before add:", s.loadFactor())
        s.add(i)
    print(s)

#test(ArraySet)
#test(LinkedSet)
#test(ArraySortedSet)
test(HashSet)
