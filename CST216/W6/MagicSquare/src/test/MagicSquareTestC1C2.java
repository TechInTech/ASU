package test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.MagicSquare;

@SuppressWarnings("unused")
public class MagicSquareTestC1C2 {	
	private MagicSquare mSquareTest;
	private MagicSquare mS1;
	private MagicSquare mS2;	

	@Before
	public void setUp() throws Exception {
		ArrayList<Integer> nList = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mSquareTest = new MagicSquare(nList);
	}

	@After
	public void tearDown() throws Exception {
		mSquareTest = null;
		mS1 = null;
		mS2 = null;
	}
	
	//Practicing assertEquals() and assertTrue/False() calls
	
	@Test
	public void testIsValidP() { //Passing case
		ArrayList<Integer> numbList = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS1 = new MagicSquare(numbList); //Initialize object with a list
		boolean expAns = true;
		boolean actAns = mS1.isValid();
		assertEquals(expAns, actAns);
	}

	@Test
	public void testIsMagicP() { //Passing case
		ArrayList<Integer> numbList = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS1 = new MagicSquare(numbList); //Initialize object with a list
		boolean expAns = true;
		boolean actAns = mS1.isMagic();
		assertEquals(expAns, actAns);
	}
	
	@Test
	public void testIsValidF() { //Failing case
		ArrayList<Integer> numbList = new ArrayList<Integer>(Arrays.asList(3, 5, 8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(numbList); //Initialize object with a list		
		assertFalse(mS2.isValid());
	}

	@Test
	public void testIsMagicF() { //Failing case
		ArrayList<Integer> numbList = new ArrayList<Integer>(Arrays.asList(3, 5, 8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(numbList); //Initialize object with a list		
		assertFalse(mS2.isMagic());
	}
}
