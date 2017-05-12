def printstring(xs):
    """ Sum all the numbers in the list xs, and return the total. """
    for x in range(xs):
        print("\n")
        for y in range(xs):
            print(y,end=' ')            
    

# Add tests like these to your test suite ...
#test(mysum([1.25, 2.5, 1.75]) == 5.5)
#test(mysum([1, -2, 3]) == 2)
#test(mysum([ ]) == 0)
#test(mysum(range(11)) == 55)  # 11 is not included in the list.
    
printstring(10)
