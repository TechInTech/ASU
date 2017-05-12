/**
 *	Write a program that reads n^2 numbers from standard input and tests 
 *  whether they form a magic square when put into matrix form. The value 
 *  of n is NOT an input to the program; n must be determined from the number
 *  of inputs. 
 *  For example, the input that creates the example matrix 
 *  above is: 8 1 6 3 5 7 4 9 2 The output is a single word, "true" if the 
 *  input produces a magic square, "false" otherwise. Your program may assume 
 *  that each input token is a whole number. 
 *  The program must verify: 
 *  1. The proper number of input values was provided. 
 *  2. Each of the numbers between 1 and n^2 occurs exactly once in the input. 
 *  3. When the numbers are arranged in a matrix, the sum of the 
 *  - rows, 
 *  - columns, 
 *  - diagonals 
 *  must be the same value.
 *  
 *	CST216
 *	HQPHAM
 */

import java.util.*;

@SuppressWarnings("unused")
public class MSquareTest {

	public static void main(String[] args) {
		int z = 0;
		MagicSQUARE mSquare = new MagicSQUARE(); //Instantiate object
		System.out.println("Please enter an array of integers of");
		System.out.println("n^2 elements and each one is separated by");
		System.out.println("a white space. Example: 8 1 6 3 5 7 4 9 2\n");
		System.out.print("Your entry: ");
		mSquare.readString();		
		boolean iValid = mSquare.isValid();
		int theSize = mSquare.getN();
		int row = mSquare.getRow();
		int col = mSquare.getCol();
		boolean iMagic = mSquare.isMagic();
		ArrayList<Integer> nL = new ArrayList<Integer>();
		int SUM = mSquare.getSum();
		int array1[] = new int[theSize];
		int Array1[] = new int[theSize];
		int array2[][] = new int[row][col];
		int Array2[][] = new int[row][col];
		nL = mSquare.get1DArray();
		/** Transfer 1D to 2D
		 *  My algorithm for doing diagonal
		 *  summing calls for a 2D array.
		 */
		for(int nL2 : nL) {
			array1[z] = nL2;
			z++;
	    }
		z = 0;
		for(int a = 0; a < row; a++) {
			for(int b = 0; b < col; b++) {
				array2[a][b] = array1[(b*row) + a];
			}
		}
		/** Create a 2D array in reverse
		 *  to compute rigth-to-left diagonal
		 */
		Array1 = reverseArray(array1); //Reverse the array
		for(int a = 0; a < row; a++) {
			for(int b = 0; b < col; b++) {
				Array2[a][b] = Array1[(b*row) + a];
			}
		}
		
		boolean Sdiag1 = summingDiag(array2, row, col, SUM);
		boolean Sdiag2 = summingDiag(Array2, row, col, SUM);
		
		//At this point I should have enough required
		//information to determine whether the input array
		//is a magic square matrix. iMagic handles summing
		//from the columns and the rows. Sdiag1 handles summing
		//from left-to-right diagonal. Sdiag2 handles summing
		//from right-to-left diagonal.
		
		System.out.println("- " + (iMagic && Sdiag1 && Sdiag2) + " -");
		
	}
	
	public static int[] reverseArray(int [] array1) {
        int index = array1.length;
        int [] array2 = new int[index];
        for(int i : array1) {
            array2[index-1]= i;
            index--;
        }
        return(array2);    
    }
	
	public static boolean summingDiag(int Array[][], int r, int c, int s) {
		
		int ARRAY2[][] = new int[r][c];
		int sum = 0; //local sum
		boolean iEqual;
		
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				ARRAY2[a][b] = Array[a][b];
			}
		}
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				if(b == a) {
					sum += ARRAY2[a][b];
				}				
			}
		}
		
		return(iEqual = (sum == s));
	}	
}
