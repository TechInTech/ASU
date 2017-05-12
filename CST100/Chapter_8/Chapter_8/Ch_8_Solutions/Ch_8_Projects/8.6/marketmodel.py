"""
File: model.py
Project 8.6

Picks the cashier with the shortest line length no further
than two lines away from a randomly chosen line.
"""

from cashier import Cashier
from customer import Customer
import random

class MarketModel(object):

    def __init__(self, lengthOfSimulation, averageTimePerCus,
                 probabilityOfNewArrival, numCashiers):
        self._probabilityOfNewArrival = probabilityOfNewArrival
        self._lengthOfSimulation = lengthOfSimulation
        self._averageTimePerCus = averageTimePerCus
        self._cashiers = list()
        for count in range(numCashiers):
            self._cashiers.append(Cashier(count + 1))
   
    def runSimulation(self):
        """Run the clock for n ticks."""
        for currentTime in range(self._lengthOfSimulation):
            # Attempt to generate a new customer
            customer = Customer.generateCustomer(
                self._probabilityOfNewArrival,
                currentTime,
                self._averageTimePerCus)

            # Send customer to a randomly chosen cashier
            # if successfully generated
            if customer != None:
                self._pickCashier().addCustomer(customer)
            # Tell all cashiers to provide another unit of service
            for cashier in self._cashiers:
                cashier.serveCustomers(currentTime)

    def __str__(self):
        """Returns the string rep of the results of the simulation."""
        return "CASHIER CUSTOMERS   AVERAGE     LEFT IN\n" + \
               "        PROCESSED   WAIT TIME   LINE\n" + \
               "\n".join(map(str, self._cashiers))

    def _pickCashier(self):
        """Returns the cashier for the next customer, based on the
        shortest line of customers no more than two lines away."""
        # Pick a random index and create a sublist of the allowable
        # cashiers
        randomIndex = random.randint(0, len(self._cashiers) - 1)
        if randomIndex == 0:
            shortList = self._cashiers[:3]
        elif randomIndex == len(self._cashiers) - 1:
            shortList = self._cashiers[-3:]
        elif randomIndex == 1:
            shortList = self._cashiers[:4]
        elif randomIndex == len(self._cashiers) - 2:
            shortList = self._cashiers[-4:]
        else:
            shortList = self._cashiers[randomIndex - 2:randomIndex + 3]
        # Search the short list for the cashier with the shortest line
        minIndex = 0
        minLineLength = 0
        for index in range(len(shortList)):
            if shortList[index].getLineLength() <= minLineLength:
                minIndex = index
                minLineLength = shortList[index].getLineLength()
        return shortList[minIndex]

