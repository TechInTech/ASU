//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/16/2015
//
//PP 10.1 Design and implement a program that reads a series of 10
//integers from the user and prints their average. Read each input 
//value as a string, and then attempt to convert it to an integer 
//using the Integer.parseInt method. If this process throws a 
//NumberFormatException (meaning that the input is not a valid number), 
//print an appropriate error message and prompt for the number again. 
//Continue reading values until 10 valid integers have been entered. 
//
//****************************************************************
import java.util.Scanner;
public class ReadTen
{
	public static void main (String [] args)
	{
	    //int a,b;
	    int[] numbers = new int [10];//In case of need for an int array
	    int count = 0; int a = 0; //Variables used in program
	    String aString ="";   //String buffer
	    int sum = 0;   //Used for summing at the end
	    
	    Scanner ReadNumbs = new Scanner(System.in); //Read from keyboard
	    do
	    {
	    	System.out.println("This is index " + count + " of the 10 element array");
	    	try
	    	{
	    		System.out.print("Enter an integer: ");
	    		aString = ReadNumbs.nextLine();
	    		a = Integer.parseInt(aString);
	    		count += 1; //If everything is good, move on, increment count
	    	}
	    	catch(NumberFormatException e)
	    	{
	    		System.out.println("An exception has been thrown. " + aString + 
	    				" is not a valid number");
	    		count -= 1; //Otherwise, decrement count
	    	} 
	    	finally
	    	{
	    		
	    			sum = sum + a; //No matter what, update the sum
	    	}
	    	
	    	
	    			
	    }while(count < 10);	    //Get out when 10 numbers reached
	    
	    System.out.println("Array length is: " + numbers.length + " sum is: " + sum);
	    System.out.println("Average is: " + ((float) (sum / numbers.length)));
	}
}
