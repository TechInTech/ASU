"""
File: hashtable.py
Project 11.3

Adds the get and remove methods to HashTable.
"""

from arrays import Array

class HashTable(object):
    "Represents a hash table."""

    EMPTY = None
    DELETED = True

    def __init__(self, capacity = 29,
                 hashFunction = hash,
                 linear = True):
        self._table = Array(capacity, HashTable.EMPTY)
        self._size = 0
        self._hash = hashFunction
        self._homeIndex = -1
        self._actualIndex = -1
        self._linear = linear
        self._probeCount = 0

    def insert(self, item):
        """Inserts item into the table
        Preconditions: There is at least one empty cell or
        one previously occupied cell.
        There is not a duplicate item."""
        self._probeCount = 0
        # Get the home index
        self._homeIndex = abs(self._hash(item)) % len(self._table)
        distance = 1
        index = self._homeIndex

        # Stop searching when an empty cell is encountered
        while not self._table[index] in (HashTable.EMPTY,
                                         HashTable.DELETED):

            # Increment the index and wrap around to first 
            # position if necessary
            if self._linear:
                increment = index + 1
            else:
                # Quadratic probing
                increment = self._homeIndex + distance ** 2
                distance += 1
            index = increment % len(self._table)
            self._probeCount += 1

        # An empty cell is found, so store the item
        self._table[index] = item
        self._size += 1
        self._actualIndex = index

    def get(self, item):
        """Returns the index if the item is present
        or -1 otherwise."""
        self._probeCount = 0
        # Get the home index
        self._homeIndex = abs(self._hash(item)) % len(self._table)
        distance = 1
        index = self._homeIndex

        # Stop searching when an empty cell is encountered
        while  (self._table[index] != HashTable.EMPTY or \
                self._table[index] == HashTable.DELETED) and \
                self._table[index] != item:

            # Increment the index and wrap around to first 
            # position if necessary
            if self._linear:
                increment = index + 1
            else:
                # Quadratic probing
                increment = self._homeIndex + distance ** 2
                distance += 1
            index = increment % len(self._table)
            self._probeCount += 1

        if self._table[index] == item:
            self._actualIndex = index
            return index
        else:
            self._actualIndex = -1
            return -1

    def remove(self, item):
        """Removes the item if it exists and returns its index or
        returns -1 otherwise."""
        # Get the home index
        self._homeIndex = abs(self._hash(item)) % len(self._table)
        distance = 1
        index = self._homeIndex

        # Stop searching when an empty cell or the target item
        # is encountered
        while  (self._table[index] != HashTable.EMPTY or \
                self._table[index] == HashTable.DELETED) and \
                self._table[index] != item:

            # Increment the index and wrap around to first 
            # position if necessary
            if self._linear:
                increment = index + 1
            else:
                # Quadratic probing
                increment = self._homeIndex + distance ** 2
                distance += 1
            index = increment % len(self._table)
            self._probeCount += 1

        if self._table[index] == item:
            self._table[index] = HashTable.DELETED
            self._actualIndex = index
            self._size -= 1
            return index
        else:
            self._actualIndex = -1
            return -1

    def __len__(self):
        return self._size

    def __str__(self):
        return str(self._table)

    def loadFactor(self):
        return float(len(self)) / len(self._table)

    def homeIndex(self):
        return self._homeIndex

    def actualIndex(self):
        return self._actualIndex

    def probeCount(self):
        return self._probeCount
        
def main():
    """Uses an example data set from Chapter 19."""
    table = HashTable(8, lambda x : x)
    for item in range(10, 71, 10):
        table.insert(item)
    print("Table:", table)
    print("Items and positions during runs of the method get:")
    for item in range(10, 71, 10):
        print(item, table.get(item))
    print("Items, positions, and the table during runs of the method remove:")
    for item in range(10, 71, 10):
        print(item, table.remove(item))
        print(table)
    

if __name__ == "__main__": main()

        



