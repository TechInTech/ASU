//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Design and implement an application that creates a histogram that
//allows you to visually inspect the frequency distribution of a set
//of values. The program should read in an arbitrary number of integers
//that are in the range 1 to 100 inclusive; then produce a chart similar
//to the one below that indicates how many input values fell in the range
//1 to 10, 11 to 20, and so on. Print one asterisk for each value entered.
//
//****************************************************************

import java.util.Scanner;

public class Histogram
{   
	
   public static void main(String[] args)
   {

      Scanner stdin = new Scanner(System.in);
      //Should have the same effect using the Scanner class
      
      final int MAXIMUM = 10;        
      final int MINIMUM = 1;         
      final int GAP   	= 10;        

      int[] dataset = new int[MAXIMUM];//Create an array of 10 ints 

      
      for (int b=0; b < dataset.length; b++)
      {
    	  dataset[b] = 0;// Initialize the array to zero
      }

      //Prompt user for integer data entry
      System.out.println("Please enter a set of integers between 1 and 100.");
      System.out.println("Enter an integer outside this range to stop.");

      
      System.out.print("Enter Integer: ");
      
	  int value = stdin.nextInt();
 
      while (value >= MINIMUM && value <= (MAXIMUM*GAP))
      {

         //Divide by gap to determine which gap to increment
    	  dataset[(value-1)/GAP] = dataset[(value-1)/GAP] + 1;

         //Next integer
         System.out.print("Enter an integer: ");
         value = stdin.nextInt();//Keep entering them integers
      }
      //Print out the histogram
      System.out.println("\nThe histogram is:");
      for (int c=0; c < dataset.length; c++)
      {
         
         //Arranging the fancy output of numbers, dashes, and asterisks
    	  System.out.print("   " + (c * GAP + 1) + " - " + (c + 1) * GAP + "\t| ");

         // Print asterisks based on the tally in dataset[i]
         for (int a=0 ; a < dataset[c] ; a++)
         {
            System.out.print("*");//Here is the asterisk
         }
         System.out.println();    //New line
      }
   }
}
