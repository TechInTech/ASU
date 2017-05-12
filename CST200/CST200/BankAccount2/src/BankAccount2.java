public class BankAccount2
{
	public double balance, interest;
	public String name;
 
	public BankAccount2()
	{
		balance = 0;
		interest = 0;
	}
 
	public BankAccount2(String nm, double initialBalance, double initialInterest)
	{
		this.name = nm;
		this.balance = initialBalance;
		this.interest = initialInterest;
	}
 
	public void deposit(double amount)
	{
		balance = (balance + amount);
	}
 
	public void withdraw(double amount)
	{
		balance = (balance - amount);
	}
 
	public void addInterest()
	{
		balance = (balance + (balance * interest));
	}
	
	public String getName()
	{
		return name;
	}
 
	public double getBalance()
	{
		return balance;
	} 
}