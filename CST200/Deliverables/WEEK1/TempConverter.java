import java.util.Scanner;

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
//************************************************************

public class TempConverter
{
	
	public static void main(String[] args)
	{
		final int BASE = 32;                      	//from example
		final double CONVERSION_FACTOR = 5.0 / 9.0; //from example
		
		double farenheitTemp = 0.0;  //Changed to identifier to be used as keyboard input
		double celsiusTemp = 0.0;    //Changed to be used in calculation from F to C
		
		Scanner scan = new Scanner(System.in); //Instantiate a class of Scanner object called scan
		System.out.print("Enter the Farenheit temperature: ");  //Prompt user for input
		farenheitTemp = scan.nextDouble(); //Used nextDouble() method
		
		celsiusTemp = (farenheitTemp - BASE) * CONVERSION_FACTOR;
		//C = (F-32) * (5.0/9.0)
		
		System.out.println("Farenheit Temperature: " + farenheitTemp +
		" Celsius equivalent: " + celsiusTemp);
		//Print out result using autoconversion and concatenation features
		//from System.out.println() method
	}

}