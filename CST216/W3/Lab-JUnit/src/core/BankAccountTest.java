package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	
	private BankAccount bATester;

	@Before
	public void setUp() throws Exception {
		String accNum = "9914374561";
		String accHold = "James Bond";
		double bal = 14598.74;
		int accType = 3;
		bATester = new BankAccount(accNum,accHold,bal,accType);
	}
	@After
	public void tearDown() throws Exception {
		bATester = null;
	}

	
	@Test
	public final void testCalculateTotalBalance() {
		double expValue = bATester.balance + (bATester.balance * (bATester.getInterestRate()/100.00));
		double actValue = bATester.calculateTotalBalance();
		assertEquals(expValue, actValue, (4 * Math.ulp(expValue)));
	}

	
	@Test
	public final void testGetInterestRate() {
		double expValue = 1.00;
		double actValue = bATester.getInterestRate();
		assertEquals(expValue, actValue, (4 * Math.ulp(expValue)));		
	}

}
