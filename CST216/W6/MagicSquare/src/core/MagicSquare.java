package core;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class MagicSquare {
	private ArrayList<Integer> numbList = new ArrayList<Integer>();	
	private int N;
	private int Row;
	private int Col;
	private int Sum;
	private int Sum2;
	
	public MagicSquare() { // Constructor
	}
	
	public MagicSquare(ArrayList<Integer> numbList) { // Constructor with params
		this.numbList = numbList;
	}
	
	/**
	 * Method readString():
	 * 		- Reads characters from standard input and 
	 *        stores values in numbList array.
	 *      - Characters are space delimited.
	 * 		- Throws exceptions on failures.
	 */
	
	public void readString() {
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
				this.numbList.add(b);;		    // add b to list		
			}// looking at next character, watch for blank space
		}// looping through entire space-delimited string
		
		b = iNumb.charAt(a) - '0'; // Handling character at the end of the string
								   // and store in b
		this.numbList.add(b);	   // add b to list
		
		inputs.close();			   // close the stream
		
		set1DArray(this.numbList);
	}
	
	/**
	 * Method: isValid()
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
		return(validMatrix);
	}
	
	/**
	 * Method: isMagic()
	 * @return true if numbList forms a magic square. 
	 * return false otherwise.
	 */
	
	public boolean isMagic() 
	{
		boolean isMagic = this.isValid(); // Check for valid square matrix.
		
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
			int sum2 = 0;
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
			this.setSum(sum);
			
			for(i = 0; ((i < col) && isMagic); i++) 
			{// If col = 3, i goes from 0, 1, 2
				sum2 = 0;
				
				for(j = 0; j < n; j += row)
				{// If n = 9, j goes from 0, 3, 6
					sum2 += numbers[i+j]; // Summing col by col					
				}				
				isMagic = (sum2 == magicNumber); // true if sum = magicNumber
			}//Summing col by col
			this.setSum2(sum2);			
		}//if(isMagic)
		return isMagic;		
	}// boolean isMagic()
	
	/**
	 * Method setN()
	 * @param 	n		int
	 * return	none
	 */	
	public void setN(int n) {
		this.N = n;
	}
	
	/**
	 * Method getN()
	 * @return	this.N		int
	 */
	public int getN() {
		return(this.N);
	}
	
	/**
	 * Method setRow()
	 * @param	n		int
	 * return	none
	 */
	public void setRow(int n) {
		this.Row = n;
	}
	
	/**
	 * Method getRow()
	 * @return	this.Row		int
	 */
	public int getRow() {
		return(this.Row);
	}
	
	/**
	 * Method setCol()
	 * @param	n	int
	 * return	none
	 */
	public void setCol(int n) {
		this.Col = n;
	}
	
	/**
	 * Method getCol()
	 * @return	this.Col	int
	 */
	public int getCol() {
		return(this.Col);
	}
	
	/**
	 * Method setSum()
	 * @param	n		int
	 * return	none
	 */
	public void setSum(int n) {
		this.Sum = n;
	}
	
	/**
	 * Method getSum()
	 * @return	this.Sum	int
	 */
	public int getSum() {
		return(this.Sum);
	}
	
	public void setSum2(int n) {
		this.Sum2 = n;
	}
	
	/**
	 * Method getSum2()
	 * @return	this.Sum2	int
	 */
	public int getSum2() {
		return(this.Sum);
	}
	/**
	 * Method	set1DArray()
	 * @param numbList	
	 * return none
	 */
	public void set1DArray(ArrayList<Integer> numbList) {
		this.numbList = numbList;
	}
	
	/**
	 * Method get1DArray()
	 * @return	this.numbList	
	 */
	public ArrayList<Integer> get1DArray() {
		return(this.numbList);
	}	
}
