def find4(astring, achar, start=0, end=None):
        """
          Find and return the index of achar in astring.
          Return -1 if achar does not occur in astring.
        """
        ix = start
        if end == None:
           end = len(astring)

        found = False
        while ix < end and not found:
            if astring[ix] == achar:
                found = True
            else:
                ix = ix + 1
        if found:
            return ix
        else:
            return -1

ss = "Python strings have some interesting methods in 1989."

print(find4(ss, 's'))
print(find4(ss, 's', 7))
print(find4(ss, 's', 8))
print(find4(ss, 's', 8, 13))
print(find4(ss, '.'))
print(ss.ascii_lowercase)
print(ss.ascii_uppercase)
print(ss.digits)
print(s.punctuation)
