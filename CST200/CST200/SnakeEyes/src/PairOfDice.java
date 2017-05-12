//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Using the Die class defined in this chapter, design and implement a
//class called PairOfDice, composed of two Die objects. Include methods
//to set and get the individual die values, a method to roll the dice, 
//and a method that returns the current sum of the two die values. 
//
//****************************************************************
public class PairOfDice
{
	private final int MAX = 6; // maximum face value
	private int[] Diefacevalue = new int[2];// current value showing on the die	
	//-----------------------------------------------------------------
	// Constructor: Sets the initial face value of this die.
	//-----------------------------------------------------------------
	public PairOfDice()
	{
		Diefacevalue[0] = 6;
		Diefacevalue[1] = 6;
	}
	//-----------------------------------------------------------------
	// Computes a new face value for this pair and returns the result.
	//-----------------------------------------------------------------
	public int[] roll()
	{
		Diefacevalue[0] = (int)(Math.random() * MAX) + 1;
		Diefacevalue[1] = (int)(Math.random() * MAX) + 1;
		return(Diefacevalue);
	}
	//-----------------------------------------------------------------
	// Face value mutator. The face value is not modified if the
	// specified value is not valid.
	//-----------------------------------------------------------------
	public void setFaceValues(int value1, int value2)
	{
		if(value1 > 0 && value1 <= MAX)
		{
			Diefacevalue[0] = value1;
		}
		
		if(value2 > 0 && value2 <= MAX)
		{
			Diefacevalue[1] = value2;
		}
	}
	//-----------------------------------------------------------------
	// Face value accessor.
	//-----------------------------------------------------------------
	public int[] getFaceValue()
	{
		return Diefacevalue;
	}
	//-----------------------------------------------------------------
	//Return the sum of the dice
	//-----------------------------------------------------------------
	public int getSumOfDice()
	{
		return(Diefacevalue[0] + Diefacevalue[1]);
	}
	//-----------------------------------------------------------------
	// Returns a string representation of this pair die.
	//-----------------------------------------------------------------
	public String toString()
	{
		String result = ("Die 1 = " + Integer.toString(Diefacevalue[0])
				+ ", " + "Die 2 = " + Integer.toString(Diefacevalue[1])
				+ ", Their sum = " + Integer.toString(Diefacevalue[1] + Diefacevalue[0]));
		return(result);
	}
}