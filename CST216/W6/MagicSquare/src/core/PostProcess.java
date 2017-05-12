package core;

import java.util.ArrayList;

public class PostProcess {
	int z;
	int theSize;
	boolean iValid;	
	int row;
	int col;
	boolean iMagic;
	ArrayList<Integer> nL;
	int SUM;  //rows
	int SUM2; //columns
	int SUMLR;//LR diag
	int SUMRL;//RL diag
	int array1[];
	int Array1[];
	int array2[][];
	int Array2[][];
	
	/**
	 * Method: Constructor
	 * @param MS	MagicSquare
	 */
	public PostProcess(MagicSquare MS) {
		this.z = 0;
		this.iValid = MS.isValid();
		this.theSize = MS.getN();
		this.row = MS.getRow();
		this.col = MS.getCol();
		this.iMagic = MS.isMagic();
		this.nL = new ArrayList<Integer>();
		this.SUM = MS.getSum(); //Get row sum
		this.SUM2 = MS.getSum2();//Get column sum
		this.nL = MS.get1DArray();
		
	}//Constructor
	
	/** Method: oneD2twoD()
	 *  My algorithm for doing diagonal
	 *  summing calls for a 2D array.
	 *  @return	this.Get_array2()	int[][]
	 */
	@SuppressWarnings("unused")
	public int[][] oneD2twoD() {
		int z = 0;
		int SizeX = this.theSize;
		int r = this.row;
		int c = this.col;
		int array1[] = new int[SizeX];
		int Array1[] = new int[SizeX];
		int array2[][] = new int[r][c];
		int Array2[][] = new int[r][c];
		
		for(int nL2 : this.nL) {
			array1[z] = nL2;
			z++;
	    }
		this.set1DArray(array1);
		
		z = 0;		
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				array2[a][b] = array1[(b*r) + a];
			}
		}
		
		this.set2DArray(array2);
		return(this.Get_array2());//This is the 2D array
	}//oneD2twoD()
	
	/**
	 * Method: Get2D_Reverse()
	 * @return	this.Get_Rev_array2()	int[][]
	 */
	@SuppressWarnings("unused")
	public int[][] Get2D_Reverse() {
		/** Create a 2D array in reverse
		 *  to compute rigth-to-left diagonal
		 */
		int z = 0;
		int SizeX = this.theSize;
		int r = this.row;
		int c = this.col;
		int Array1[] = new int[SizeX];
		int Array2[][] = new int[r][c];
		
		Array1 = this.reverseArray(this.array1); //Reverse the array
		this.setR1DArray(Array1);
		
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				Array2[a][b] = Array1[(b*r) + a];
			}
		}
		this.set_Rev_2DArray(Array2);
		return(this.Get_Rev_array2());
	}
	
	/**
	 * Method reverseArray()
	 * @param array1	int[]
	 * @return array2	int[]
	 */
	public int[] reverseArray(int[] array1) {
	    int index = array1.length;
	    int[] array2 = new int[index];
	    
	    for(int i : array1) {
	        array2[index-1]= i;
	        index--;
	    }
	    return(array2);    
	}	
	
	/**
	 * Method: set1DArray()
	 * @param t_Array	int[]
	 */
	public void set1DArray(int[] t_Array) {
		this.array1 = t_Array;
	}
	
	/**
	 * Method: Get_1D_array()
	 * @return this.array1	int[]
	 */
	public int[] Get_1D_array() {
		return(this.array1);
	}
	
	/**
	 * Method: setR1DArray()
	 * @param t_Array	int[]
	 */
	public void setR1DArray(int[] t_Array) {
		this.Array1 = t_Array;
	}//Reverse1D setter
	
	/**
	 * Method: Get_R1D_array()
	 * @return	this.Array1	int[]
	 */
	public int[] Get_R1D_array() {
		return(this.Array1);
	}//Reverse1D Getter
	
	/**
	 * Method: set2DArray()
	 * @param t_Array	int[][]
	 */
	public void set2DArray(int[][] t_Array) {
		this.array2 = t_Array;
	}
	
	/**
	 * Method: Get_array2()
	 * @return this.array2	int[][]
	 */
	public int[][] Get_array2() {
		return(this.array2);
	}
	
	/**
	 * Method: set_Rev_2DArray
	 * @param t_Array int[][]
	 */
	public void set_Rev_2DArray(int[][] t_Array) {
		this.Array2 = t_Array;
	}
	
	/**
	 * Method: Get_Rev_array2()
	 * @return this.Array2 int[][]
	 */
	public int[][] Get_Rev_array2() {
		return(this.Array2);
	}
	
	/**
	 * Method: summingDiag()
	 * @return iEqual	boolean
	 */
	
	@SuppressWarnings("unused")
	public boolean summingDiag0() {		
		int r = this.row;
		int c = this.col;		
		
		int sum = 0; //local sum
		boolean iEqual;
		
				
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				if(b == a) {
					sum += this.array2[a][b];
				}				
			}
		}
		this.setSUMLR(sum);
		return(iEqual = (sum == this.SUM));
	}//Method bracket
	
	@SuppressWarnings("unused")
	public boolean summingDiag1() {		
		int r = this.row;
		int c = this.col;
		
		int sum = 0; //local sum
		boolean iEqual;
		
				
		for(int a = 0; a < r; a++) {
			for(int b = 0; b < c; b++) {
				if(b == a) {
					sum += this.Array2[a][b];
				}				
			}
		}
		this.setSUMRL(sum);
		return(iEqual = (sum == this.SUM));
	}//Method bracket
	
	/**
	 * Method: setSUMLR()
	 * @param s		int
	 */
	public void setSUMLR(int s) {
		this.SUMLR = s;
	}
	
	/**
	 * Method: getSUMLR()
	 * @return	this.SUMLR	int
	 */
	public int getSUMLR() {
		return(this.SUMLR);
	}
	
	/**
	 * Method: setSUMRL()
	 * @param s		int
	 */
	public void setSUMRL(int s) {
		this.SUMRL = s;
	}
	
	/**
	 * Method: getSUMRL()
	 * @return this.SUMRL	int
	 */
	public int getSUMRL() {
		return(this.SUMRL);
	}
}//Class bracket
