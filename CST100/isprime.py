def is_prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

print (is_prime(25))
print (is_prime(7))
print (is_prime(251))
print (is_prime(20))
