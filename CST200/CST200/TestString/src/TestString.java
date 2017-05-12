//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/30/2015
//
//Overload the multiConcat method from Exercise 5.25 such that
//if the integer parameter is not provided, the method returns 
//the string concatenated with itself. For example, if the 
//parameter is "test", the return value is "testtest".
//
//   
//**********************************************************

public class TestString  //The .java to submit to javac
{

	public static void main(String[] args) //The main method
	{
		String text = multiConcat("hi",4);//Declare a variable
										  //and assign it to the call
		String text2 = multiConcat("test"); //Declare a variable
		   								  //and assign it to the call
		//test2 tests out the overloading feature of java compiler

		System.out.printf("%s\n",text); //Print out the result
		System.out.printf("%s\n",text2); //Print out the result
	}//End of main entrance
	
	public static String multiConcat(String s, int width) //multiConcat method
	{
		String NewString=""; //Use NewString because s is immutable
		
		if(width < 2) //if cont is less than 2
		{
			return(s); //return the original string
		}//End if
		else //Otherwise
		{
			for(int i = 0; i < width; i++) //Set up the loop from 0 to count - 1
			{
				NewString = NewString + s; //add the same string (i-1) times
			}
				
			return(NewString);//give it back to caller
		}//End else
	}//End multiConcat
	
	public static String multiConcat(String s) //multiConcat overloaded
	{
		String NewString=""; //Use NewString because s is immutable
		for(int i = 0; i < 2; i++) //Set up the loop from 0 to count - 1
		{
				NewString = NewString + s; //add the same string (i-1) times
		}
				
		return(NewString);//give it back to caller
		
	}//End multiConcat
			
}//End .java class to submit to javac
