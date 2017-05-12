//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Design and implement a class called Box that contains 
//instance data that represents the height, width, and 
//depth of the box. Also include a boolean variable called
//full as instance data that represents if the box is full
//or not. Define the Box constructor to accept and initialize
//the height, width, and depth of the box. Each newly created 
//Box is empty (the constructor should initialize full to false).
//Include getter and setter methods for all instance data. 
//Include a toString method that returns a one-line 
//description of the box. 
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
