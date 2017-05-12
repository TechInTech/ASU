import random

def lottery():
    # returns 6 numbers between 1 and 59
    for i in range(5):
        yield random.randint(1, 59)

    # returns a 7th number between 1 and 15
    yield random.randint(1,35)

luckynumbers = [random_number for random_number in lottery()]
#for random_number in lottery():
print("Do not abuse your luck\nRun the program once per week")
print("Last digit is the power ball...", luckynumbers)
