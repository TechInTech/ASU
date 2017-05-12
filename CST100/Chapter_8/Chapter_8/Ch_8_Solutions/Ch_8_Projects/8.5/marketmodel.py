"""
File: model.py
Project 8.5

Picks the cashier with the shortest line length.
"""

from cashier import Cashier
from customer import Customer

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
        shortest line of customers."""
        minIndex = 0
        minLineLength = 0
        for index in range(len(self._cashiers)):
            if self._cashiers[index].getLineLength() <= minLineLength:
                minIndex = index
                minLineLength = self._cashiers[index].getLineLength()
        return self._cashiers[minIndex]

