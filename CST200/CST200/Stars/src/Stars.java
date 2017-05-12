//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/23/2015
//
//Modify the star program to create a diamond shape
//using asterisk characters. Implementation with swtich/case
// and for loops.
//
//   
//**********************************************************

public class Stars
{
	//---------------------------------------------------
	//Prints a diamond shape using asterisk characters
	//---------------------------------------------------
	public static void main(String[] args)
	{
		final int MAX_ROWS = 10;
		
		System.out.println();//Give an initial blank line.
		for(int row = 1; row <= MAX_ROWS; row++)//Top half of diamond
		{
				switch(row)
				{
					case 1:
						  System.out.println("    *    ");
						  break;
					case 3:
						  System.out.println("   ***   ");
						  break;
					case 5:
						  System.out.println("  *****  ");
						  break;
					case 7:
						  System.out.println(" ******* ");
						  break;
					case 9:
						  System.out.println("*********");
						  break;
				}
		}
		
		for(int row = (MAX_ROWS-1); row >= 1; row--)//Bottom half
		{
			switch(row)
			{
				case 1:
					  System.out.println("    *    ");
					  break;
				case 3:
					  System.out.println("   ***   ");
					  break;
				case 5:
					  System.out.println("  *****  ");
					  break;
				case 7:
					  System.out.println(" ******* ");
					  break;
				case 9:
					  System.out.println("*********");
					  break;
			}
		}
		
	}
}
