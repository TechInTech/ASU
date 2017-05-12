import java.util.Scanner;		//Needed this class for input

public class Gregorian
{
	//------------------------------------------------------
	//Design and implement an application that reads an integer
	//value representing a year from the user. The purpose of
	//the program is to determine if the year is a leap year
	//(and therefore has 29 days in February) in the Gregorian
	//calendar. A year is a leap year if it is divisible by 4,
	//unless it is also divisible by 100 but not 400. For example,
	//the year 2003 is not a leap year, but 2004 is. The year 1900
	//is not a leap year because it is divisible by 100, but the
	//year 2000 is a leap year because even though it is divisible
	//by 100, it is also divisible by 400. Produce an error message
	//for any input value less than 1582 (the year the Gregorian 
	//calendar was adopted).
	//
	//------------------------------------------------------
	
	public static void main(String[] args)
	{
		final int GREGORIAN_YEAR = 1582; // Constant to compare to
		int x1=0,x2=0;
		boolean isLeapyear = false;
		//variables for calculating distance of 2 points
		
				
		Scanner scan = new Scanner(System.in);//Keyboard input
		
		System.out.print("Enter the year in question (must be greater than or equal to 1582): ");
		x1 = scan.nextInt();
		while(x1 < GREGORIAN_YEAR)
		{
			System.out.println("Error, the year must be greater than  or equal to 1582");
			System.out.print("Enter the year in question (must be greater than or equal to 1582): ");
			x1 = scan.nextInt();
		}
				
		if ((x1 % 4) == 0) //First test, fail this then game is over
		{
			//Check for other conditions
			//Must be either passing both 100 and 400 check
			//or failing both 100 and 400 check in order to be
			//a leap year
			if((((x1 % 100) == 0) && ((x1 % 400) == 0)) || (((x1 % 100) != 0) && ((x1 % 400) != 0)))
			{
				isLeapyear = true;
			}
			else
			{
				isLeapyear = false;
			}
		}
		else //Clearly not a leap year
		{
			isLeapyear = false;
		}
		
		if(isLeapyear) //Display meassage based on isLeapyear logic
			System.out.println("The year " + x1 + " is a leap year.");
		else
			System.out.println("The year " + x1 + " is not a leap year.");
				
	}
}