"""
File: model.py
Project 7.8

Integrate the infix to postfix converter into the evaluator.
"""

from tokens import Token
from scanner import Scanner
from arraystack import ArrayStack
from converter import IFToPFConverter

class PFEvaluatorModel(object):

    def evaluate(self, sourceStr):
        self._evaluator = None
        self._converter = IFToPFConverter(Scanner(sourceStr))
        postfix = self._converter.convert()
        self._evaluator = PFEvaluator(postfix)
        value = self._evaluator.evaluate()
        return value
   
    def format(self, sourceStr):
        normalizedStr = ""
        scanner = Scanner(sourceStr);
        while scanner.hasNext():
            normalizedStr += str(scanner.next()) + " "
        return normalizedStr;   

    def evaluationStatus(self):
        """Check to see if an evaluation has been done first."""
        if self._evaluator is None:
            evalStatus = ""
        else:
            evalStatus = str(self._evaluator)
        return str(self._converter) + "\n" + evalStatus

    
class PFEvaluator(object):
   
    def __init__(self, postfix):
        self._expressionSoFar = ""
        self._operandStack = ArrayStack()
        self._postfix = postfix
        
    def evaluate(self):
        for currentToken in self._postfix:
            self._expressionSoFar += str(currentToken) + " "
            if currentToken.getType() == Token.INT:
                self._operandStack.push(currentToken)
            else: 
                t2 = self._operandStack.pop()
                t1 = self._operandStack.pop()
                result = Token(self._computeValue(currentToken,
                                                  t1.getValue(),
                                                  t2.getValue()))
                self._operandStack.push(result)
        result = self._operandStack.pop()
        return result.getValue();   

    def __str__(self):
        result = "\n"
        if self._expressionSoFar == "":
            result += "Portion of expression processed: none\n"
        else: 
            result += "Portion of expression processed: " + \
                   self._expressionSoFar + "\n"
        if self._operandStack.isEmpty():
            result += "The stack is empty"
        else:
            result += "Operands on the stack          : " + \
                      str(self._operandStack)
        return result

    def _computeValue(self, op, value1, value2):
        result = 0;
        theType = op.getType()
        if theType == Token.PLUS:
            result = value1 + value2;
        elif theType == Token.MINUS:
            result = value1 - value2;
        elif theType == Token.MUL:
            result = value1 * value2;
        elif theType == Token.DIV:
            if value2 == 0:
                raise ZeroDivisionError("Attempt to divide by 0")
            result = value1 // value2;
        elif theType == Token.EXPO:
            result = value1 ** value2;
        else:
            raise AttibuteError("Unknown operator")
        return result
