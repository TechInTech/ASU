//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/15/2015
//
//Given the user input in total number of seconds, convert
//the user input to hours, minutes, and seconds.
//
//Useful facts:
//   1 hour = 3600 seconds, 1 minute = 60 seconds
//    
//   
//**********************************************************

import java.util.Scanner;

public class SecondsToHRS
{
	
	public static void main(String[] args)
	{
		final int BASE = 32;                      	//from example
		final double CONVERSION_FACTOR = 5.0 / 9.0; //from example
		
		int hours, minutes, seconds, total_seconds;
		int hour_mod, minute_mod;
		
		Scanner scan = new Scanner(System.in); //Instantiate a class of Scanner object called scan
		
		System.out.print("Enter the the total number of seconds: ");  //Prompt user for hours input
		total_seconds = scan.nextInt(); //Used nextInt() method
		
		hour_mod = total_seconds % 3600; //Get the modulo to know the remainder
		minute_mod = hour_mod % 60;      //Get the modulo to know the remainder
		seconds = minute_mod;  //seconds is the remainder of minutes % 60
		hours = ((total_seconds - hour_mod) / 3600); //find how many times total_seconds went into 3600		
		minutes = ((hour_mod - minute_mod) / 60);    //find how many times hour_mod went into 60	
		
		System.out.println("hours   = " + hours);  // print out hours
		System.out.println("minutes = " + minutes);// print out minutes
		System.out.println("seconds = " + seconds);// print out seconds
		
		//Print out result using autoconversion and concatenation features
		//from System.out.println() method
	}

}

