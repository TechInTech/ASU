import math

def check_anagrams(first_words, second_words):
    a=len(first_words)
    b=len(second_words) 
    c = first_words
    d = second_words
    e = ''.join(sorted(c))
    f = ''.join(sorted(d))

    if (e == f):
        print(1)
    else:
        print(0)
    

check_anagrams('cinema', 'iceman')
check_anagrams('host', 'shot')
check_anagrams('aba', 'bab')
check_anagrams('train', 'rain')

          
