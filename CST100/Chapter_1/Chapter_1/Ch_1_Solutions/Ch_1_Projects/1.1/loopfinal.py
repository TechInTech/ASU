import string


def printout1(x):
    y2 = ''
    for y in range(x):        
        y2 = y2 + str(y) + ' '       
        #print(str(y),end=' ')
           
    return y2

xs = 10

for i in range(10):
    yz = printout1(xs)
    yz = ((' ' * i) + yz)
    print(yz)
    print("\n")
    xs -= 1

