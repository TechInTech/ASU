package banking.primitive.core;
import static org.junit.Assert.*;

import org.junit.Test;


public class CheckingTest 
{

	@Test
	public void testDeposit() 
	{
		//Instantiate object of Checking class
		Account CheckingTester = new Checking("Checking101");		
		assertTrue(!CheckingTester.deposit(-584.45f));
		assertTrue(CheckingTester.deposit(584.45f));
        
	}

	@Test
	public void testWithdraw() 
	{
		//Instantiate object of Checking class
		Account CheckingTester = new Checking("Checking101");

		assertTrue(!CheckingTester.withdraw(-75.56f));
		assertTrue(CheckingTester.withdraw(356.45f));
		assertTrue(!CheckingTester.withdraw(30501.33f));
	}
}
