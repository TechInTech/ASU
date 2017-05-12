"""
File: librarytest.py
Project 1.10

This module tests the Book, Patron, and Library classes.
"""
from library import Patron, Book, Library

def testPatron():
    print("\nTesting a patron")
    p = Patron("Ken")
    print("Expect Ken, 0 books out:", p)
    print("Expect Ken:", p.getName())
    print("Expect 0:", p.getNumBooksOut())
    p.inc()
    print("Expect Ken, 1 books out:", p)
    p.dec()
    print("Expect Ken, 0 books out:", p)
    

def testBook():
    print("\nTesting a book")
    b = Book("Live by Night", "Dennis Lehane")
    print("Expect")
    print("Title: Live by Night\nAuthor: Dennis Lehane\nNot checked out\nWait list:")
    print(b)
    print("Expect Live by Night:", b.getTitle())
    print("Expect Dennis Lehane:", b.getAuthor())
    print("Expect None", b.getPatron())
    p = Patron("Ken")
    print("Expect The book is not checked out:", b.returnMe())
    print("Expect None:", b.borrowMe(p))
    print("Expect\nTitle: Live by Night\nAuthor: Dennis Lehane")
    print("Checked out to: Ken, 1 books out\nWait list:")
    print(b)
    print("Expect Ken, 1 books out:", b.getPatron())
    print("Expect This book is already checked out:", b.borrowMe(p))
    secondP = Patron("Carolyn")
    print("Expect This book is already checked out:", b.borrowMe(secondP))
    print("Expect\nTitle: Live by Night\nAuthor: Dennis Lehane")
    print("Checked out to: Ken, 1 books out\nWait list:\nCarolyn, 0 books out")
    print(b)
    print("Expect Book loaned to a waiting patron:", b.returnMe())
    print("Expect\nTitle: Live by Night\nAuthor: Dennis Lehane")
    print("Checked out to: Carolyn, 1 books out\nWait list:")
    print(b)

def testLibrary():
    lib = Library()
    b1 = Book("Live by Night", "Dennis Lehane")
    b2 = Book("A Time of Gifts", "Patrick Leigh Fermor")
    b3 = Book("Barchester Towers", "Anthony Trollope")
    for b in (b1, b2, b3): lib.addBook(b)
    p1 = Patron("Ken")
    p2 = Patron("Joshua")
    p3 = Patron("Sara")
    for p in (p1, p2, p3): lib.addPatron(p)
    print("\nThe first library:")
    print(lib)
    lib.save("books.dat", "patrons.dat")
    secondLib = Library("books.dat", "patrons.dat")
    print("\nThe second library (a copy):")
    print(secondLib)
    print("Expect Ken, 0 kooks out:", lib.getPatron("Ken"))
    print("Expect None:", lib.getPatron("Carolyn"))
    print("Expect Live by Night:", lib.getBook("Live by Night").getTitle())
    print("Expect None:", lib.getBook("Mystic River"))
    print("Expect None:", lib.removeBook("Live by Night"))
    print("\nLibrary:")
    print(lib)
    print("Expect Book's title is not in the library:", lib.removeBook("Mystic River"))
    print("Expect None:", lib.removePatron("Ken"))
    print("\nLibrary:")
    print(lib)
    print("Expect Patron's name is not in the library:", lib.removePatron("Ken"))
          
    
#testPatron()
#testBook()
testLibrary()
