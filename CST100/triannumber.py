def print_triangular_numbers(n):
    approx = 0.5 * n
    better = 0.5 * (n * (n + 1))
    while  better !=  approx:
        approx = better
        better = 0.5 * (n * (n + 1))
        print (n,"\t", better)
    return approx


print_triangular_numbers(1)
print_triangular_numbers(2)
print_triangular_numbers(3)
print_triangular_numbers(4)
print_triangular_numbers(5)
