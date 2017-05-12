package banking.interfaces;

import javax.swing.JOptionPane;

import primitive.core.DepositParameter;

@SuppressWarnings("serial")
public abstract class Account implements Asset
{
	protected float accountBalance =0.0F; //CST316 ACTIVITY 1.4
	protected String name;

	public Account(String n)
	{
		name = n;
	}

	public Account(String n, float b)
	{
		name = n;
		accountBalance = b;
	}

	public void display()
	{
	    JOptionPane.showMessageDialog(null, "Account " + name + " has $" + accountBalance);
	}

	public String getName()
	{
		return name;
	}

	public float getBalance()
	{
		return accountBalance;
	}
	
	public abstract void deposit(DepositParameter parameterObject);
	public abstract void withdraw(float amount);

    public String toString() {
    	return "Account " + name + " has $" + accountBalance +"\n";
    }
}
