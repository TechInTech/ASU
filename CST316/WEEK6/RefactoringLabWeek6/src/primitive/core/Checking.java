package primitive.core;

import banking.interfaces.AAccount;

@SuppressWarnings("serial")
public class Checking extends AAccount {
	private int numWithdraws = 0;

	private Checking(String name) {
		super(name);
	}

    public static Checking createChecking(String name) {
        return new Checking(name);
    }

	public Checking(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		System.out.print("Checking ");
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		accountBalance = accountBalance + parameterObject.amount;
	}

	public void withdraw(float amount) {
		accountBalance = accountBalance - amount;
		numWithdraws++;
		if (numWithdraws > 10)
			accountBalance = accountBalance - 2;
	}

	public String toString() {
		return "Chk:" + getName() + " <-> " + getBalance() + " <-> ";
	}

    public char charAt(int i) {
        return name.charAt(i);
    }
}
