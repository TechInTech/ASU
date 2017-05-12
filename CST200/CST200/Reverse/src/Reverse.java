/**
 * Implement a class called Reverse that uses a stack to output a 
 * set of elements input by the user in reverse order.
 * @author Hieu Pham
 */

import java.util.Scanner;
import java.util.Stack;

class Reverse
{
   public static void main(String args[])
   {
       Scanner in = new Scanner(System.in); //For standard input (keyboard)
       Stack FirstStack  = new Stack(); //Stack to hold original chars
            
       
       String originalstring   =  "";  //Buffer to hold chars for processing     
       String newstring        =  "";  //Buffer to hold chars for processing
      
       //Prompting user for required input, no checking provided
       System.out.print("Enter the integers, each separated by a space: ");
       originalstring = in.nextLine(); //Get the stream until carriage return is pressed
      
       String[] Chars = originalstring.split(" ", 1); //Separate the characters out 1
       												  //at a time, remove the blanks
       
       for(String Char : Chars)  //Using for each loop instead, to iterate the Chars elements
       {
           for(int i = 0; i < Char.length(); i++) //Store chars to the stack with known size
           {
               FirstStack.push(Char.charAt(i));   //Stuffing in all elements.
           }         
           
           while(!FirstStack.empty())
           {               
               newstring += FirstStack.pop(); //Pull the chars out for printing
           }
       }
       System.out.println("\nThe reverse of your numbers are: " + newstring + "\n");
   }   //Done
}