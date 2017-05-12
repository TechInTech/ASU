import string

def encrypt(message, cipher):#Encryting with original and cipher code
    alphabet = "abcdefghijklmnopqrstuvwxyz" #low case alphabet char array
    encrypted = '' #char array variable name encryted created and init.
    for ch in message: #for loop key on ch and indexing on message length
        if ch == ' ':  #if ch is a blank
            encrypted = encrypted + ' ' #Add blank to the encrypted variable
        else: #Otherwise
            pos = alphabet.index(ch) #variable pos gets the index position
                                       #of the alphabet char array (oth base)
            encrypted = encrypted + cipher[pos] #Remap encrypted chars to
                                                #cipher chars
    return encrypted #Return with encrypted char array

def decrypt(encrypted, cipher):#Decryting with original and cipher code
    alphabet = "abcdefghijklmnopqrstuvwxyz" #low case alphabet char array
    decrypted = '' #char array variable name encryted created and init.
    for ch in encrypted: #for loop key on ch and indexing on encrypted
                         #message length
        if ch == ' ': #if ch is a blank
            decrypted = decrypted + ' ' #Add blank to the encrypted variable
        else: #Otherwise
            pos = cipher.index(ch) #variable pos gets the index position
                                   #of the alphabet char array (oth base)
            decrypted = decrypted + alphabet[pos] #Remap decrypted chars to
                                                  #orinal alphabet chars
            
    return decrypted #Return with decrypted char array


cipher = "badcfehgjilknmporqtsvuxwzy"

encrypted = encrypt('we are at war', cipher)
print(encrypted)

decrypted = decrypt(encrypted, cipher)
print(decrypted)
