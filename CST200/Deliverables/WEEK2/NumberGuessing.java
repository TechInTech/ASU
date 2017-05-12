//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 01/23/2015
//
//Generate a random integer in the range of 1 to 100
//Prompt user for an integer input
//Compare user input against random number generated
//Keep count of user's attempts
//Interact with user for continuing or quitting option.
//
//   
//**********************************************************

import java.util.Scanner; //Needed this for keyboard input
 
public class NumberGuessing //The class under development
{
      public static void main(String[] args) //Entry point
      {
            int x2,x1; //one for program, one for user
            int repeat=0,count=0;//Sentinel and counter
            boolean playon = true;//Flag for continue of quit status
            
            Scanner scan = new Scanner(System.in);//Instantiate an
            									  //object of Scanner class
            
            x2 = (int) (Math.random() * 99 + 1); //Use random method
            									 //of the Math class
            
            do
            {
            	count = 0;//Initialize for each run loop
            	                
            	do
            	{
            		System.out.print("Enter your guess (a number between 1 and 100): ");
                    x1 = scan.nextInt();//Get user input
                   	if (x1 == x2)//User = random
                  	{
                        	System.out.println("Right on. Congratulations!");
                  	}
                  	else if (x1 < x2)//User < random
                  	{
                        	System.out.println("Too low...");
                  	}
                  	else if (x1 > x2)//User > random
                  	{
                        	System.out.println("Too high...");
                  	}
                  
                  	count++;//increment the trial counter
            	}while (x1 != x2);//repeat while user != random
            	
            	//if user = random, exit loop and say something
            	System.out.printf("You took %d tries\n",count);
            	
            	//Play another round prompting.
            	System.out.println("Do you want to play again?");
            	
            	System.out.print("Enter 1 for yes or 9999 for no ");
            	repeat = scan.nextInt();//Get user input
            	switch(repeat)//Respond to user's choice accordingly
            	{
            		case 1://Yes, user wants to play on
            			playon = true;//Keep play loop active
            			x2 = (int) (Math.random() * 99 + 1); //Use random method
						                                     //of the Math class
            			break;//Done processing
            		case 9999://No, user wants to quit
            			playon = false;//Deactivate play loop
            			break;//Done processing
            		default://Any other choice, quit
            			playon = false;//Deactivate the play loop
            			break;//Done processing
            	}            	
            	
            }while (playon == true);//Keep playing while playon is true
      }
}