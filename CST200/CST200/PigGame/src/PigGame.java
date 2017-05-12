import java.util.Scanner; //Needed for input from keyboard
//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Using the PairOfDice class from programming project 5.10,
//design and implement a class to play a game called Pig. In this 
//game, the user competes against the computer. On each turn, 
//the current player rolls a pair of dice and accumulates points. 
//The goal is to reach 100 points before your opponent does. 
//If, on any turn, the player rolls a 1, all points accumulated for
//that round are forfeited and control of the dice moves to the other
//player. If the player rolls two 1’s in one turn, the player loses 
//all points accumulated thus far in the game and loses control of 
//the dice. The player may voluntarily turn over the dice after each
//roll. Therefore the player must decide to either roll again 
//(be a pig) and risk losing points or relinquish control of the 
//dice, possibly allowing the other player to win. Implement the 
//computer player such that it always relinquishes the dice after 
//accumulating 20 or more points in any given round.
//
//****************************************************************
public class PigGame
{
	public static void main(String[] args)
	{
		//--------------Variables used during the game
		//to set various flags
		final int GOAL = 100;//Set the game to 100 points
		int[] hfv = new int[2];
		int[] pfv = new int[2];
		int  humsums = 0,pcsums = 0;
		int  pctotal = 0, humtotal = 0, pcmatchtotal = 0;
		int humansel = 0;
		boolean gameon = true, humanwinner = false, pcwinner = false;
		boolean one1status = false, two1status = false;
		boolean pclostturn = false,humlostturn = false;		
		boolean roundover = false;
		
		PairOfDice HumPoD = new PairOfDice();
		PairOfDice PCPoD = new PairOfDice();
		
		Scanner game = new Scanner(System.in);
		String str = "";
		
		//--------End of variable block
		
		//This is the superloop that will break when user
		//selected neither a Y nor a Y (or a CTRL C will break it, too)
		while(gameon)
		{
			//These variables must be re-initialized
			//for the new loop.
			two1status = false;
			one1status = false;
			pclostturn = false;
			humlostturn = false;
			humanwinner = false;
			pcwinner = false;
			roundover = false;
			pcsums = 0;
			pctotal = 0;
			pcmatchtotal = 0;
			humsums = 0;
			humtotal = 0;
			gameon = true;
			//End of re-initialization
			
			System.out.print("Want to play Pig (Y/N)? ");			 
			str = game.next(); //Prompting user and capture keyboard input
			
			if(!str.equalsIgnoreCase("Y"))
			{
				 gameon = false;//Causes the super loop to break
			}
			else
			{
				while(!roundover) //If the round is still going on
				{
					//These variables must be re-initialized
					//for the new loop.
					two1status = false;
					one1status = false;
					pclostturn = false;
					humlostturn = false;
					humanwinner = false;
					pcwinner = false;
					pcsums = 0;
					pctotal = 0;
					pcmatchtotal = 0;
					humsums = 0;
					humtotal = 0;
					//End the re-initialization block
					
					while((!pclostturn)&&(!humanwinner))
					{//While the human has not won, and the PC
						//Did not lose its turn yet
						
						//These variables must be re-initialized
						//for the new loop.						
						two1status = false;
						one1status = false;
						System.out.println("[PC] My turn in progress...");
						pfv = PCPoD.roll();//roll the dice
						System.out.println("[PC] Die 1: " + pfv[0]);
						System.out.println("[PC] Die 2: " + pfv[1]);
					
				        //Testing the object.roll()
						System.out.println("pc-sum: " + (pfv[0] + pfv[1]));
				
						if((pfv[0]==1) &&(pfv[1]==1))
						{//Testing for rule violation
							System.out.println("Two 1s detected");
							two1status = true;
							//This is both dice have 1s
						}
						else if((pfv[0]==1) || (pfv[1]==1))
						{
							System.out.println("a 1 detected");
							one1status = true;//May not need this
							//This is otherwise, either die have a 1
						}
									
						if(one1status)//one 1 rule check
						{
							System.out.println("Lost the turn");
							pclostturn = true;//Set this to kill the loop
							pcsums = 0;//Apply sanction
						}
				
						if(two1status) //two 1s rule check
						{
							System.out.println("Lost the turn");
							pclostturn = true;//Set this to kill the loop
							pctotal = 0;
						}
				
						if((!one1status)&&(!two1status))//No rule violation
						{
							System.out.println("Legitimate points.");
							pcsums = pcsums + PCPoD.getSumOfDice();//sum the roll up
							pctotal = pctotal + pcsums;//transfer it to pctotal
							pcsums = 0; //Zero this out because pcsums is only used
	 							//for holding the current roll's sum.
							System.out.println("PC points so far: " + pctotal);
							if(pctotal >= 20)//Autorelinquish feature
							{//Must relinquish its turn every 20 points
								pcmatchtotal = pcmatchtotal + pctotal;
								System.out.println("Relinquish at: " + pcmatchtotal);
								pctotal = 0;//Empty out pctotal
								pclostturn = true;//Force Relinquish to happen
							}
							
							if(pcmatchtotal >= GOAL)
							{//Check if we are at 100 points yet
								roundover = true; //If so, terminate the round
								if(pcmatchtotal > humtotal)
								{//if our point is greater than the human's
									pcwinner = true;//We have won
									System.out.println("Computer won...");
									pclostturn = true;//Terminate the turn
								}
							}
						}
					}//The pc has lost its turn
				
					//------------------Human's turn------------------------
				
				
					while((!humlostturn) && (!pcwinner))
					{
						//These variables must be re-initialized
						//for the new loop.
						//
						//The human will have to be prompted for rolling on
						//or relinquish the turn
						//--------------------------------------
						two1status = false;
						one1status = false;
						System.out.println("[Human] My turn in progress...");
						hfv = HumPoD.roll();//roll the dice
						System.out.println("[Human] Die 1: " + hfv[0]);
						System.out.println("[Human] Die 2: " + hfv[1]);
					
				        //Test out the object.roll() method
						System.out.println("human-sum: " + (hfv[0] + hfv[1]));
				
						//Rule checking
						if((hfv[0]==1) &&(hfv[1]==1))
						{
							System.out.println("Two 1s detected");
							two1status = true;
						}
						else if((hfv[0]==1) || (hfv[1]==1))
						{
							System.out.println("a 1 detected");
							one1status = true;//May not need this					 
						}
						
						//Apply rules
						if(one1status)
						{
							System.out.println("Lost the turn");
							humlostturn = true;//Set this to kill the loop
							humsums = 0;//Apply sanction
						}
				
						if(two1status)
						{
							System.out.println("Lost the turn");
							humlostturn = true;//Set this to kill the loop
							humtotal = 0;//Apply the sanction.
						}
				
						if((!one1status)&&(!two1status))
						{//No rule violation
							System.out.println("Legitimate points.");
							humsums = humsums + HumPoD.getSumOfDice();
							//Test out the object.getSumOfDice() method
							
							humtotal = humtotal + humsums;
							humsums = 0; //Zero this out because pcsums is only used
	 							//for holding the round's sum.
							System.out.println("Human Points so far: " + humtotal);
							
							//Check to see if goal has been reached
							if(humtotal >= GOAL)
							{
								roundover = true;
								if(humtotal > pcmatchtotal)
								{
									humanwinner = true;
									System.out.println("Human won...");
									humlostturn = true;
								}
							}//Otherwise, prompt user for the next move
							
							//Prompt to see if the human wants to relinquish or 
							//keep going...
							System.out.println("[Human] Rolling...?");
					 		System.out.print("[Human] Press 1 to roll, Press 2 to relinquish: ");
					 		humansel = game.nextInt();
					 		switch(humansel)
					 		{
					 		case 1:
					 			  humlostturn = false;//roll again
					 			  break;
					 		case 2:
					 			  humlostturn = true;//relinquish turn to player 2
					 			  break;
					 	    default:
					 	    	   humlostturn = false;//roll again
					 	    	   break;
					 		}//End of the switch
						}
					}//The human lost his turn
				}//Another loop
				
			}//End else
			
		}//End while(gameon)
		
	}//End main()
}//End class
