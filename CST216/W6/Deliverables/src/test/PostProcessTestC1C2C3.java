package test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.MagicSquare;
import core.PostProcess;

@SuppressWarnings("unused")
public class PostProcessTestC1C2C3 {
	private MagicSquare mSquareTest;
	private MagicSquare mS1;
	private MagicSquare mS2;
	private PostProcess PProc1;
	private PostProcess PProc2;
	private PostProcess PProc3;
	
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
		PProc1 = null;
		PProc2 = null;
		PProc3 = null;
	}
	
	
	@Test
	public void testGetSUMP() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(nL);	
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS2.getN();
		int row = mS2.getRow();
		int col = mS2.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS2.isValid();
		iMagic = mS2.isMagic();
		SUM_H = mS2.getSum();
		SUM_V = mS2.getSum2();
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		int expAns = 15;
		
		assertEquals(SUM_H,expAns);//Sum, row.
	}
	
	@Test
	public void testGetSUM2P() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(nL);	
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS2.getN();
		int row = mS2.getRow();
		int col = mS2.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS2.isValid();
		iMagic = mS2.isMagic();
		SUM_H = mS2.getSum();
		SUM_V = mS2.getSum2();
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		
		int expAns = 15;
		
		assertEquals(SUM_V,expAns);//Sum, column.
	}
	
	@Test
	public void testGetSUMF() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(nL);	
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS2.getN();
		int row = mS2.getRow();
		int col = mS2.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS2.isValid();
		iMagic = mS2.isMagic();		
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		int expAns = 22;
		
		assertFalse(mS2.getSum() == expAns);//Sum, row.
	}
	
	@Test
	public void testGetSUM2F() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS2 = new MagicSquare(nL);	
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS2.getN();
		int row = mS2.getRow();
		int col = mS2.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS2.isValid();
		iMagic = mS2.isMagic();
		SUM_H = mS2.getSum();
		SUM_V = mS2.getSum2();
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		
		int expAns = 34;
		
		assertFalse(mS2.getSum2() == expAns);//Sum, column.
	}
	
	@Test
	public void testGetSUMLRP() {
		ArrayList<Integer> nList = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mSquareTest = new MagicSquare(nList);
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mSquareTest.getN();
		int row = mSquareTest.getRow();
		int col = mSquareTest.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mSquareTest.isValid();
		iMagic = mSquareTest.isMagic();
		SUM_H = mSquareTest.getSum();
		SUM_V = mSquareTest.getSum2();
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		SUM_LR_DIAG = PProc1.getSUMLR();
		SUM_RL_DIAG = PProc1.getSUMRL();
		
		int expAns = 15;
		assertEquals(expAns,SUM_LR_DIAG);//Sum, left->right, diagonal		
	}

	@Test
	public void testGetSUMRLP() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS1 = new MagicSquare(nL);
		PProc2 = new PostProcess(mS1);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS1.getN();
		int row = mS1.getRow();
		int col = mS1.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS1.isValid();
		iMagic = mS1.isMagic();
		SUM_H = mS1.getSum();
		SUM_V = mS1.getSum2();
		array2 = PProc2.oneD2twoD();
		array1 = PProc2.Get_1D_array();
		Array1 = PProc2.reverseArray(array1);
		Array2 = PProc2.Get2D_Reverse();
		
		boolean Sdiag1 = PProc2.summingDiag0();
		boolean Sdiag2 = PProc2.summingDiag1();
		
		SUM_RL_DIAG = PProc2.getSUMRL();
		
		int expAns = 15;
		assertEquals(expAns,SUM_RL_DIAG);//Sum, right->left, diagonal
	}
	
	@Test
	public void testGetSUMLRF() {
		ArrayList<Integer> nList = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mSquareTest = new MagicSquare(nList);
		PProc1 = new PostProcess(mSquareTest);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mSquareTest.getN();
		int row = mSquareTest.getRow();
		int col = mSquareTest.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mSquareTest.isValid();
		iMagic = mSquareTest.isMagic();
		SUM_H = mSquareTest.getSum();
		SUM_V = mSquareTest.getSum2();
		array2 = PProc1.oneD2twoD();
		array1 = PProc1.Get_1D_array();
		Array1 = PProc1.reverseArray(array1);
		Array2 = PProc1.Get2D_Reverse();
		
		boolean Sdiag1 = PProc1.summingDiag0();
		boolean Sdiag2 = PProc1.summingDiag1();
		SUM_LR_DIAG = PProc1.getSUMLR();		
		
		int expAns = 22;
		assertFalse(PProc1.getSUMLR() == expAns);//Sum, left->right, diagonal	
	}

	@Test
	public void testGetSUMRLF() {
		ArrayList<Integer> nL = new ArrayList<Integer>(Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2));
		mS1 = new MagicSquare(nL);
		PProc2 = new PostProcess(mS1);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = mS1.getN();
		int row = mS1.getRow();
		int col = mS1.getCol();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		boolean iValid = false;		
		boolean iMagic = false;
		
		iValid = mS1.isValid();
		iMagic = mS1.isMagic();
		SUM_H = mS1.getSum();
		SUM_V = mS1.getSum2();
		array2 = PProc2.oneD2twoD();
		array1 = PProc2.Get_1D_array();
		Array1 = PProc2.reverseArray(array1);
		Array2 = PProc2.Get2D_Reverse();
		
		boolean Sdiag1 = PProc2.summingDiag0();
		boolean Sdiag2 = PProc2.summingDiag1();
		
		SUM_RL_DIAG = PProc2.getSUMRL();
		
		int expAns = 22;
		assertFalse(PProc2.getSUMRL() == expAns);//Sum, right->left, diagonal
	}
}
