"""
File: expressiontree.py
Project 10.8  Adds the ^ operator for exponentiation.

Defines nodes for expression trees.
"""

class LeafNode(object):
    """Represents an integer."""

    def __init__(self, data):
        self._data = data

    def value(self):
        return self._data
      
    def __str__(self):
        return str(self._data)

    def prefix(self):
        return str(self)

    def infix(self):
        return str(self)

    def postfix(self):
        return str(self)


class InteriorNode(object):
    """Represents an operator and its two operands."""

    def __init__(self, op, leftOper, rightOper):
        self._operator = op
        self._leftOperand = leftOper
        self._rightOperand = rightOper

    def value(self):
        value1 = self._leftOperand.value()
        value2 = self._rightOperand.value()
        if self._operator == '+':
            result = value1 + value2
        elif self._operator == '-':
            result = value1 - value2
        elif self._operator == '*':
            result = value1 * value2
        elif self._operator == '/':
            result = value1 / value2
        elif self._operator == '^':
            result = value1 ** value2
        else:
            result = 0
        return result

    def prefix(self):
        return self._operator + " " + \
               self._leftOperand.prefix() + " " + \
               self._rightOperand.prefix()

    def infix(self):
        return "(" + self._leftOperand.infix() + " " + \
               self._operator + " " + \
               self._rightOperand.infix() + ")"
    
    def postfix(self):
        return self._leftOperand.postfix() + " " + \
               self._rightOperand.postfix() + " " + \
               self._operator


def main():
    a = LeafNode(4)
    b = InteriorNode('+', LeafNode(2), LeafNode(3))
    c = InteriorNode('*', a, b)
    c = InteriorNode('^', c, b) 
    print("Expect ((4 * (2 + 3) ^ (2 + 3)):", c.infix())
    print("Expect ^ * 4 + 2 3 + 2 3       :", c.prefix())
    print("Expect 4 2 3 + * 2 3 + ^       :", c.postfix())
    print("Expect 3200000                 :", c.value())

if __name__ == "__main__":
    main()




