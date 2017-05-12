//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 05/22/2015
//
//Write a java program that repeatedly displays a prompt, 
//then reads a line of text from System.in and prints each line 
//back out to System.out. When the user types "quit" (in upper or lower case)
//the program terminates.
//An example of the expected output (including user input) is shown below:
//In: This is user input
//Out: This is user input
//In: La
//Out: La
//In: Quit.
//
//**********************************************************
import java.util.Scanner;

public class Program0
{
	
	public static void main(String[] args)
	{
		String aString = "";     //String buffer to hold user input
		String bString = "";     // Another string buffer to compare and convert, etc...
		Scanner ReadIn = new Scanner(System.in); //ReadIn is the input stream
		
		do
	    {		    	
	    		System.out.print("In: "); //Display the prompt
	    		aString = ReadIn.nextLine(); //Read a line of text from System.in
	    		bString = aString.toLowerCase(); //convert all to lower case for internal processing
	    		if(!bString.equals("quit")) //When input is not "quit"
	    		{
	    			System.out.println("Out: " + aString); //print each line back to System.out
	    		}
	    		//repeatedly display a prompt	
	    }while(!bString.equals("quit"));	    //Get out when bString is "quit"
		ReadIn.close();
	}

}