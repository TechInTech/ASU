//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Rewrite the SnakeEyes program using a PairOfDice object. 
//
//****************************************************************
public class SnakeEyes
{
	//-----------------------------------------------------------------
	// Creates two Die objects and rolls them several times, counting
	// the number of snake eyes that occur.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		final int ROLLS = 500;
		int[] numx = new int[2];
		int[] fv = new int[2];
		int  count = 0, sums = 0;
		
		PairOfDice PoD1 = new PairOfDice(); //Each die will be 6
		System.out.println();
		System.out.println(PoD1);
		System.out.println();
		
		//Set the face values
		PoD1.setFaceValues(3, 3);
		System.out.println();
		System.out.println(PoD1);
		System.out.println();
		//Get the face values
		fv = PoD1.getFaceValue();
		System.out.println();
		System.out.println("Die 1: " + Integer.toString(fv[0]));
		System.out.println("Die 2: " + Integer.toString(fv[1]));
		System.out.println();
		//Get the sum
		sums = PoD1.getSumOfDice();
		System.out.println();
		System.out.println("Their sum is: " + Integer.toString(sums));
		System.out.println();
				
		for (int roll=1; roll <= ROLLS; roll++)
		{
			numx = PoD1.roll();
			
			if (numx[0] == 1 && numx[1] == 1) // check for snake eyes
				count++;
		}
		
		System.out.println("Number of rolls: " + ROLLS);
		System.out.println("Number of snake eyes: " + count);
		System.out.println("Ratio: " + (float)count / ROLLS);
 	}
}
