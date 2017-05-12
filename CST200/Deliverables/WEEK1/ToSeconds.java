//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/15/2015
//
//Given the user inputs for hours, minutes, and seconds, convert the user input
//the user inputs seconds.
//
//Useful facts:
//   1 hour = 3600 seconds; 1 minute = 60 seconds
//    
//   
//**********************************************************

import java.util.Scanner;

public class ToSeconds
{
	
	public static void main(String[] args)
	{
		final int BASE = 32;                      	//from example
		final double CONVERSION_FACTOR = 5.0 / 9.0; //from example
		
		int hours, minutes, seconds, total_seconds;
		
		Scanner scan = new Scanner(System.in); //Instantiate a class of Scanner object called scan
		
		System.out.print("Enter the hours: ");  //Prompt user for hours input
		hours = scan.nextInt(); //Used nextInt() method
		
		System.out.print("Enter the minutes: ");  //Prompt user for minutes input
		minutes = scan.nextInt(); //Used nextInt() method
		
		System.out.print("Enter the seconds: ");  //Prompt user for seconds input
		seconds = scan.nextInt(); //Used nextInt() method
		
		total_seconds = ((hours * 3600) + (minutes * 60) + seconds);
		
		System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds equals: " + total_seconds + " seconds.");
		
		//Print out result using autoconversion and concatenation features
		//from System.out.println() method
	}

}