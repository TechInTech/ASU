/*
 * Program to display an Nth-line Pascal triangle
 * by applying recursive approach. N = 9
 * @Hieu Pham
 */

public class PascalTriangle
{
	 public static final int ROW = 9;
	 private static int MAX = 0;
	 private static int len = 0;
	 private static int[][] pascal  = new int[ROW +1][];
	 
	public static void main(String[] args)
	{
		int N = 9;
		int IntArray[] = new int[0];
		//There are 9 lines in the triangle
		OutputTriangle(IntArray, N);		
	} 

	static void OutputTriangle(int Matrix[], int Loops)
	{ 

		// Matrix needed to calculate the next row of the triangle 
		int MatrixCopy[] = new int[Matrix.length + 1]; 
		
		
		MatrixCopy[0] = 1; // first item of row is always a 1
		
		// This loop is strictly for new interior values 
		for (int a = 1; a < Matrix.length; a++) //Matrix size increases due to recursion
		{			
			MatrixCopy[a] = Matrix[a-1] + Matrix[a]; //Summing interior values					
		}

		MatrixCopy[MatrixCopy.length - 1] = 1; // last item of row is also 1
		
		// Display the newly calculated values on one line 
		for (int b = 0; b < MatrixCopy.length; b++)
		{
			//System.out.print(MatrixCopy[b] + " ");
			//System.out.println(MatrixCopy[b]);
		}
		//System.out.println(); // end of the line 

		/*
         * Printing spacing requires adding whitespace to certain numbers to accommodate
         * space that larger numbers occupy. First determine what the largest number 
		 * to be printed (Array.len) programmatically. Then determine the number of 
		 * digits in the numbers (stringlen and MAXLENGTH). Then use this number to print
		 * whitespace for numbers that have less digits than the largest number to give
		 * the printing proper triangular effect.
         * 
         * Use the format method.
         */
		
		// Recursion 
		if(MatrixCopy.length < Loops) 
			OutputTriangle(MatrixCopy, Loops);
		
		pascal[1] = new int[3];
        pascal[1][1] = MatrixCopy[0];
        
        for (int i = 2; i <= ROW; i++)
        {
        	for (int j = 1; j < pascal[i].length - 1; j++)
            {
        		pascal[i][j] = 
            }
        }
        
        
	} 
} 