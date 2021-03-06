package primitive.core;

import banking.interfaces.AAccount;

//ACTIVITY 2-2 SMELL BETWEEN CLASSES <Primitive Obsession>
//import banking.interfaces.IInterestBearing;

@SuppressWarnings("serial")
//public class Savings extends AAccount implements IInterestBearing {
public class Savings extends AAccount {  //ACTIVITY 2-2 SMELL BETWEEN CLASSES <Primitive Obsession>
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		accountBalance = accountBalance + parameterObject.amount - 0.50F;
	}

	public void withdraw(float amount) {
		accountBalance = accountBalance - amount;
		numWithdraws++;
		if (numWithdraws > 3)
			accountBalance = accountBalance - 1;
	}

	public void accrueInterest() {
		accountBalance = accountBalance * 1.001F;
	}

	public String toString() {
		return "Sav:" + getName() + " <-> " + getBalance() + " <-> ";
	}
}
