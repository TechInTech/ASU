"""
File: quicksort.py
Project 3.9

Uses insertion sort in quicksort to sort sublists whose length < 50.
"""

def quickSort(lyst):
    quicksortHelper(lyst, 0, len(lyst) - 1)


def quicksortHelper(lyst, left, right):
    """Calls insertionSort if length of sublist < 50."""
    if left < right:
        if right - left + 1 >= 50:
            pivotLocation = partition(lyst, left, right)
            quicksortHelper(lyst, left, pivotLocation - 1)
            quicksortHelper(lyst, pivotLocation + 1, right)
        else:
            insertionSort(lyst, left, right)

def partition(lyst, left, right):
    # Find the pivot and exchange it with the last item
    middle = (left + right) // 2
    pivot = lyst[middle]
    lyst[middle] = lyst[right]
    lyst[right] = pivot
    # Set boundary point to first position
    boundary = left
    # Move items less than pivot to the left
    for index in range(left, right):
        if lyst[index] < pivot:
            swap(lyst, index, boundary)
            boundary += 1
    # Exchange the pivot item and the boundary item
    swap(lyst, right, boundary)
    return boundary

def insertionSort(lyst, left, right):
    """Note extra args for bounds of sublist."""
    i = left + 1
    while i <= right:
        itemToInsert = lyst[i]
        j = i - 1
        while j >= 0:
            if itemToInsert < lyst[j]:
                lyst[j + 1] = lyst[j]
                j -= 1
            else:
                break
        lyst[j + 1] = itemToInsert
        i += 1

def swap(lyst, i, j):
    """Exchanges the values at i and j."""
    lyst[i], lyst[j] = lyst[j], lyst[i]

import random

def main():
    """Tests quicksort with 4 lists."""
    size = 40
    for count in range(4):
        lyst = list(range(size))
        random.shuffle(lyst)
        quickSort(lyst)
        print(lyst)
        print("Size: ", size)
        size *= 4    

if __name__ == "__main__":
    main()
    
