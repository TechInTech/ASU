//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/15/2015
//
//Given the user input in Fahrenheit, convert the user input
//to Celsius degrees.
//
//Useful facts:
//   C = (5.0/9.0) * (F - 32)
//   where C is the temperature in Celsius and
//   F is the temperature in Fahrenheit
//**********************************************************

import java.util.Scanner;

public class ToSeconds
{
	
	public static void main(String[] args)
	{
		final int BASE = 32;                      	//from example
		final double CONVERSION_FACTOR = 5.0 / 9.0; //from example
		
		int hours, minutes, seconds, total_seconds;
		int hour_mod, minute_mod;
		
		Scanner scan = new Scanner(System.in); //Instantiate a class of Scanner object called scan
		
		System.out.print("Enter the the total number of seconds: ");  //Prompt user for hours input
		seconds = scan.nextInt(); //Used nextInt() method
		
		hour_mod = seconds % 3600;		
				
		
		
		System.out.println("hour mod" + hour_mod);
		
		//Print out result using autoconversion and concatenation features
		//from System.out.println() method
	}

}

