import java.util.*;
import java.io.*;

/**
 * Palindrome demonstrates the use of queue and stack to
 * determine whether a given string of characters is a palindrome.
 * CST200, Spring 2015
 * @author Hieu Pham
 * @version 4.0
 */
public class Palindrome
{
		@SuppressWarnings("unchecked")
		public static void main(String[] args)
		{
			Scanner iCh = new Scanner(System.in);//Keyboard input
			String ICH = "";
			char TestChar; //Use this to equate input string	
			//char TC=0; //Use this to equate input string
			Scanner again = new Scanner(System.in);//Need this for messages and prompting
			String Prompting=""; //Need this for messages and prompting
			boolean confirmed = false; //Need to confirm palindrome
			boolean longstring = false;
			int a=0,b=0,c=0; //Need for computing in various places
			
			@SuppressWarnings("rawtypes")
			Stack CharStack = new Stack();
			@SuppressWarnings("rawtypes")
			Queue CharQueue = new LinkedList();
			//Declaring the stack and the queue here will force
			//them to be empty each pass through
				
			System.out.print("Please enter a string of characters: ");
			ICH=iCh.nextLine();//User enters a \n terminated string here
			b = ICH.length(); //Determine the length of user's string
			
			if(b>16)
			{
				System.out.println("string too long");
				longstring = true;
			}
			
			while(c < b) //Read the input string one character at a time.
			{
				TestChar=ICH.charAt(c); //Process one char at a time
				CharStack.push(TestChar); //Load the stack
				CharQueue.add(TestChar);  //Load the queue
				//A copy of ICH goes at the top of the stack and at the rear end
				//of the queue.
				c++;
			}// end while
			confirmed = true;
			a = 1;
			//Some attempt to guard the stack to avoid 
			//the emptystack situation while in processing
			try
			{ 
				//Repetitively compare the top element of the stack
				//and the front element of the queue
				if(CharStack.peek() == CharQueue.peek())
				{
					CharStack.pop();
					CharQueue.remove();
					a++;
				}
				else
				{
					//Change confirmed flage to false when
					//the comparison failed
					confirmed = false;
				}
			}				
			catch(EmptyStackException e)
			{ 
				System.out.println("empty structure"); 
			}
			
			//Processing the result...
			if((confirmed == true)&&(!longstring))
			{
				System.out.println("The string is a palindrome.");
			}
			else
			{
				System.out.println("The string is a Not palindrome.");
				if(!longstring)
				{
					System.out.println("The string is too long.");	
				}
			}				
		}			
}