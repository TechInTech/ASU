"""
File: fib.py
Project 3.7

Employs memoization to improve the efficiency of recursive Fibonacci.
Counts the calls and displays the results.

The complexity of this implementation is linear.  The reason is that when n > 2,
each fib(n) is computed as the sum of the constant-time lookups of 
of fib(n - 1) and fib(n - 2).  There are approximately n of these lookups.
"""

class Counter(object):
    """Tracks a count."""

    def __init__(self):
        self._number = 0

    def increment(self):
        self._number += 1

    def __str__(self):
        return str(self._number)

def fib(n, counter, table):
    """Count the number of calls of the Fibonacci
    function."""
    counter.increment()
    if n < 3:
        return 1
    else:
        # Attempt to get values for n - 1 and n - 2
        # from the table
        # If unsuccessful, recurse and add results to
        # the table
        result1 = table.get(n - 1, None)
        if result1 is None:
            result1 = fib(n - 1, counter, table)
            table[n - 1] = result1
        result2 = table.get(n - 2, None)
        if result2 is None:
            result2 = fib(n - 2, counter, table)
            table[n - 2] = result2
        return result1 + result2

def main():
    """Tests the function with some powers of 2."""
    problemSize = 2
    print("%12s%15s" % ("Problem Size", "Calls"))
    for count in range(5):
        counter = Counter()

        # The start of the algorithm (note the empty dictionary)
        fib(problemSize, counter, {})
        # The end of the algorithm
    
        print("%12d%15s" % (problemSize, counter))
        problemSize *= 2

if __name__ == "__main__":
    main()
