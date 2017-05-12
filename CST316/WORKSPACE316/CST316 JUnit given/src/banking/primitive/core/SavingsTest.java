package banking.primitive.core;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.primitive.core.Account.State;

public class SavingsTest {

	@Test
	public void testDeposit() {
		
		//Initialization (18)
		Account SavingsTester = new Savings("Savings101");
		
		State s = SavingsTester.getState();
		
		String TheType = SavingsTester.getType();
		
		//(19A)
		assertTrue((s == State.OPEN));
		assertTrue(!(s == State.CLOSED));
		assertTrue(!(s == State.OVERDRAWN));
		//Bug revealing (Should have been "Savings", was "Checking"
		assertTrue("Savings".equals(TheType));
		assertTrue(!("Checking".equals(TheType)));
		//(19B)
		assertTrue(!SavingsTester.deposit(-0.05f));
		assertTrue(SavingsTester.deposit(12554.45f));
		//(22)
		SavingsTester.setState(State.CLOSED);
		assertTrue(!SavingsTester.deposit(253.87f));
		SavingsTester.setState(State.OPEN);
		assertTrue(SavingsTester.deposit(15.87f));
	}

	@Test
	public void testWithdraw() {
		Account SavingsTester = new Savings("Savings101");
		State s = SavingsTester.getState();
		String TheType = SavingsTester.getType();
		
		//(33A)
		assertTrue((s == State.OPEN));
		assertTrue(!(s == State.CLOSED));
		assertTrue(!(s == State.OVERDRAWN));
		
		//Bug revealing (Should have been "Savings", was "Checking"
		assertTrue("Savings".equals(TheType));
		assertTrue(!("Checking".equals(TheType)));
		
		//(33B)
		assertTrue(!SavingsTester.withdraw(-0.5f));
		assertTrue(SavingsTester.withdraw(356.45f));
		assertTrue(!SavingsTester.withdraw(30501.33f));
		
		//(39)
		SavingsTester.setState(State.OPEN);
		assertTrue(SavingsTester.withdraw(123.45f));
		SavingsTester.setState(State.CLOSED);
		assertTrue(!SavingsTester.withdraw(234.56f));
	}

}
