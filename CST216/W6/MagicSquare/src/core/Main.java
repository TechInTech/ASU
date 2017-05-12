package core;

import java.util.*;

/**
 * 
 * @author Hieu Pham
 * @version 1.0.0
 *
 */

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		int z = 0;
		boolean iValid = false;		
		boolean iMagic = false;
						
		MagicSquare mSquare = new MagicSquare(); //Instantiate object
		
		System.out.println("Please enter an array of integers of");
		System.out.println("n^2 elements and each one is separated by");
		System.out.println("a white space. Example: 8 1 6 3 5 7 4 9 2\n");
		System.out.print("Your entry: ");
		
		mSquare.readString();		
		PostProcess PProc = new PostProcess(mSquare);
		
		int SUM_V = 0;
		int SUM_H = 0;
		int SUM_LR_DIAG = 0;
		int SUM_RL_DIAG = 0;
		int theSize = PProc.theSize;
		int row = PProc.row;
		int col = PProc.col;
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		
		iValid = PProc.iValid;
		iMagic = PProc.iMagic;
		SUM_H = PProc.SUM;
		SUM_V = PProc.SUM2;
		array2 = PProc.oneD2twoD();
		array1 = PProc.Get_1D_array();
		Array1 = PProc.reverseArray(array1);
		Array2 = PProc.Get2D_Reverse();		
		boolean Sdiag1 = PProc.summingDiag0();
		boolean Sdiag2 = PProc.summingDiag1();
		System.out.println("The Horizontal sum is: " + PProc.SUM);
		System.out.println("The Verticalal sum is: " + PProc.SUM2);
		System.out.println("The L-R diagonal sum is: " + PProc.getSUMLR());
		System.out.println("The R-L diagonal sum is: " + PProc.getSUMRL());
		SUM_LR_DIAG = PProc.getSUMLR();
		SUM_RL_DIAG = PProc.getSUMRL();
		
		if((SUM_V == SUM_LR_DIAG) && (SUM_V == SUM_RL_DIAG) && (SUM_V == SUM_H)) {
			System.out.println("-- You got a square matrix --");
		}
		else {
			System.out.println("-- You don't have a square matrix --");
		}
		//System.out.println("The LR diagonal sum is: " + Sdiag1);
		//System.out.println("The RL diagonal sum is: " + Sdiag2);		
		
	}				
}
