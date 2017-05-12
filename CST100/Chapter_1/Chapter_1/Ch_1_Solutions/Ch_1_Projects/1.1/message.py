"""
Author: Hieu Pham
ID: 0953-827
Section: 82909
Date: 11/12/2014

Design an encryption function, using ord() and chr() built-in functions
Design an decryption function, using chr() and ord() built-in functions
Prompt user to enter regular message and an integer key, encrypt the
message with given key.
Prompt user for encrypted message and hack the message with different cipher
key values using the decrypt function.

"""

import string

def encrypt(message, cipher):#Encryting with original and cipher code    
    encrypted = '' #char array variable name encryted created and init.
    for ch in message: #for loop key on ch and indexing on message length
        if ((ord(ch) + cipher) > 126):  #if ch is bigger than ~
            encrypted = encrypted + chr(((ord(ch) + cipher)-127)+32)
            #Add character to the key and with offset values
        else: #Otherwise
            encrypted = encrypted + chr(ord(ch) + cipher)
            #Just add character to the key
    return encrypted #Return with encrypted char array

def decrypt(encrypted, cipher):#Decryting with original and cipher code
    decrypted = '' #char array variable name encryted created and init.
    for ch in encrypted: #for loop key on ch and indexing on encrypted length
        if ((ord(ch) - cipher) < 32):  #if character/key pair is not a space
            decrypted = decrypted + chr(((ord(ch) - cipher)+127)-32)
            #Offset the value and subtract the space, reverse encrypt
        else: #Otherwise
            decrypted = decrypted + chr(ord(ch) - cipher)
            #No space, just subtract encrypted to key
    return decrypted #Return with decrypted char array



emessage=str(input("Enter a regular message to encode: "))
cipher = int(input("Enter a key value (between 0 and 100) for encoding: "))
encrypted = encrypt(emessage, cipher)
print(encrypted)
dmessage=str(input("Enter an encrypted message: "))
for i in range(101): #Print out from 0 to 100 keys
    decrypted = decrypt(dmessage, i)
    print("Key:",i,"-> Decoded Message:",decrypted)

