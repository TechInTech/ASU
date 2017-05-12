import java.util.*;
import java.io.*;

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

@SuppressWarnings("unused")
public class MagicSQUARE { // The MagicSQUARE class
	
	private ArrayList<Integer> numbList = new ArrayList<Integer>();	
	private int N;
	private int Row;
	private int Col;
	private int Sum;
	
	public MagicSQUARE() { // Constructor
	}
	
	/**
	 * Method readString():
	 * 		- Reads characters from standard input and 
	 *        stores values in numbList array.
	 *      - Characters are space delimited.
	 * 		- Throws exceptions on failures.
	 */
	
	public void readString()
	{
		int a, b; 								 // Some working integers used 
												 // during process.
		Scanner inputs = new Scanner(System.in); // inputs = standard input
		String iNumb = inputs.nextLine();        // nextLine() advances the 
		                                         // scanner past the current line
		                                         // and returns the input that was
		                                         // skipped.
		// At this point there should be a string of numeric characters
		// of something like this: 8 1 6 3 5 7 4 9 2
		// Now process the string.
		
		for(a = 0; a < (iNumb.length() - 1); a++)// Loop from a to (string length - 1)
		{
			if(iNumb.charAt((a + 1)) == ' ') // if next char is a space
			{      
				b = iNumb.charAt(a) - '0';   // subtract the character to ASCII 0
											 // and store in b
				numbList.add(b);		     // add b to list		
			}// looking at next character, watch for blank space
		}// looping through entire space-delimited string
		
		b = iNumb.charAt(a) - '0'; // Handling character at the end of the string
								   // and store in b
		numbList.add(b);		   // add b to list
		
		inputs.close();			   // close the stream
		
		set1DArray(this.numbList);
	}
	
	/**
	 * @return true if:
	 * 		1. numbList contains only whole numbers, AND
	 * 		2. numbList has no duplicates, AND
	 * 		3. size of numbList forms a perfect square.
	 * 
	 * 		return false otherwise.
	 */
	public boolean isValid() {
		boolean validMatrix = false;
		int n = numbList.size();
		int s = (int) Math.sqrt(n);
		this.setN(n);
		this.setRow(s);
		this.setCol(s);
		
		if (n == (Math.pow(s, 2))) // s and n checks each other
		{						   // for perfect square condition.
			
			Set<Integer> theSet = new HashSet<Integer>(numbList);
			
			if(theSet.size() == numbList.size()) {
				
			    /* Each of the numbers between 1 and n^2 occurs 
			     * exactly once in the input.
			     */				
				validMatrix = true;
			}
		}
		return validMatrix;
	}
	
	/**
	 * @return true if numbList forms a magic square. 
	 * return false otherwise.
	 */
	
	public boolean isMagic() 
	{
		boolean isMagic = isValid(); // Check for valid square matrix.
		
		if(isMagic) // if isMagic is true
		{
			int i,j; // Some integers for processing
			int n = numbList.size(); // Set n to the list size
			
			int numbers[] = new int[n]; // Create a local list from numbList
			for(i = 0; i < n; i++)
			{
				numbers[i]= numbList.get(i); // Transfer characters from numbList
			}
			
			int magicNumber = 0; // Placeholder for magic number calculation.
			int row = (int) Math.sqrt(n);// Only need row - setting
			int col = row;				 // col to row for a square matrix.
			int sum = 0;				 // need for calculating sum.
			isMagic = true;				 // setting isMagic state.			
			
			for(i = 0; i < col; i++)
			{
				magicNumber += numbers[i]; // Pick either row or col with equal outcome
			}// Setting magicNumber to the sum of a column.
			
			setSum(magicNumber);
			
			for(i = 0; ((i < n) && isMagic); i += row) 
			{// Going from 0 in the multiple of row
				// If n = 9, i goes from 0, 3, and 6
				sum = 0;	// Reset sum each time through the loop.
				
				for(j = 0; j < col;j ++)
				{
					sum += numbers[i+j]; // Summing row by row
				}				
				isMagic = (sum == magicNumber); // true if sum = magicNumber
			}//Summing row by row
			
			for(i = 0; ((i < col) && isMagic); i++) 
			{// If col = 3, i goes from 0, 1, 2
				sum = 0;
				
				for(j = 0; j < n; j += row)
				{// If n = 9, j goes from 0, 3, 6
					sum += numbers[i+j]; // Summing col by col					
				}				
				isMagic = (sum == magicNumber); // true if sum = magicNumber
			}//Summing col by col
			
			
			
		}//if(isMagic)
		return isMagic;		
	}// boolean isMagic()
	
	public void setN(int n) {
		this.N = n;
	}
	
	public int getN() {
		return(this.N);
	}
	
	public void setRow(int n) {
		this.Row = n;
	}
	
	public int getRow() {
		return(this.Row);
	}
	
	public void setCol(int n) {
		this.Col = n;
	}
	
	public int getCol() {
		return(this.Col);
	}
	
	public void setSum(int n) {
		this.Sum = n;
	}
	
	public int getSum() {
		return(this.Sum);
	}
	
	public void set1DArray(ArrayList<Integer> numbList) {
		this.numbList = numbList;
	}
	
	public ArrayList<Integer> get1DArray() {
		return(this.numbList);
	}
}