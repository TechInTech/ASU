import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankerList
{
	public static void main(String[] args)
	{
		List<BankAccount2> customer = new ArrayList<BankAccount2>();
		
		customer.add(new BankAccount2("Hieu Pham", 100285.59, 0.05));
		customer.add(new BankAccount2("Liu Kang", 79485.67, 0.07));
		customer.add(new BankAccount2("Barrack Obama", 805865.97, 0.09));
		customer.add(new BankAccount2("Jacque Chirac", 1220735.77, 0.15));
		customer.add(new BankAccount2("James Bond", 274572.59, 0.03));
		customer.add(new BankAccount2("Owahtagu Siam", 397545.89, 0.06));
		customer.add(new BankAccount2("Laura Heinz", 997548.96, 0.23));
		customer.add(new BankAccount2("Jenna Nguyen", 979462.85, 0.33));
		customer.add(new BankAccount2("Andrew Pham", 1000285.35, 0.45));
		customer.add(new BankAccount2("Alyssa Pham", 2339885.59, 0.25));
		
		Iterator<BankAccount2> iTer = customer.iterator();
		System.out.println("Using an explicit iterator...");
		System.out.println();		
		while(iTer.hasNext())
		{
			BankAccount2 c2 = iTer.next();
			c2.addInterest();
			System.out.print(c2.getName() + ", ");
	        System.out.format("$%.2f%n", c2.getBalance());						  
		}		
	}
}