/*
		The game of Pig is a simple two player dice game in which the first player to reach 100 or
		more points wins. Players take turns. On each turn a player rolls a six-sided die. After each
		roll:
		• If the player rolls a 2-6 then he can either:
		• ROLL AGAIN or
		• HOLD. At this point the sum of all rolls made this turn is added to the player’s
		total score and it becomes the other player’s turn.
		• If the player rolls a 1 then the player loses his turn. He gets no new points and it
		becomes the opponent’s turn.
		If a player reaches 100 or more points after holding then the player wins.
		Write a program that plays the game of Pig, where one player is a human and the other is
		the computer. Allow the human to input ‘r’ (or ‘R’) to roll again or ‘h’ (or ‘H’) to hold.
		The computer program should play according to the following rule: Keep rolling on the
		computer’s turn until it has accumulated 20 or more points, then hold. Of course, if the
		computer wins or rolls a 1 then the turn ends immediately. Allow the human to roll first.
		Write your program using at least two functions:
		int humanTurn(int humanTotalScore);
		int computerTurn(int computerTotalScore);
		These functions should perform the necessary logic to handle a single turn for either the computer
		or the human. The input parameter is the total score for the human or computer. The
		functions should return the turn total to be added to the total score upon completion of the
		turn. For example, if the human rolls a 3 and 6 and then holds, then humanTurn should return
		9. However, if the human rolls a 3 and 6 and then a 1, then the function should return 0.

		Programmer: Hieu Pham
		ASUID:		0953-827
		SER221
		FALL B, 2015

*/

//Bring in essential functions
//to support program operation.
#include <cstdlib>
#include <iostream>
#include <ctime>
using namespace std;

const int MAX_SCORE = 100; 					//Cannot be changed during run-time
int humanTurn(int &humanTotalScore); 		//Required functions, with pass-by-reference argument
int computerTurn(int &computerTotalScore);	//Required functions, with pass-by-reference argument
int Serving(); 								//Serving return the dice value to its caller

int main()
{
    bool winning = 1;
    int humanTotalScore = 0, computerTotalScore = 0;

    do
    {
        humanTurn(humanTotalScore); //Human gets to go first.
        computerTurn(computerTotalScore);
		cout << "Computers Score: " << computerTotalScore << endl;

		if((humanTotalScore < MAX_SCORE) && (computerTotalScore < MAX_SCORE))
		{
			winning = 1;
		}
		else //Invalidate the do/while loop - Game over
		{
			winning = 0;
		}
    }while(winning == 1);

    if((winning == 0) && (humanTotalScore > computerTotalScore))
    {
        cout << "You win!";
    }
    else //The computer wins
    {
        cout << "Better luck next time!";
    }
    return(0);
}


int humanTurn(int &humanTotalScore)
{
    int scorenow = 0;
    int GetPoint;
    char iSel;

    cout << "-- Human's total score is: " << humanTotalScore << " --" << endl;
    cout << "Press [r] to roll your dice again, or [h] to hold." << endl;
    cin >> iSel;

    while(iSel == 'r')
    {
        srand(time(NULL)); //setting the seed of the random number generator to the current time
						   //to maintain different randomness
        GetPoint = Serving();
        if(GetPoint == 1)
        {
            cout << "A [1] occurred, Human's turn ended." << endl;
            break;
        }
        else
        {
            scorenow += GetPoint;
            cout << "You roll a " << GetPoint << ". Your score this turn is: " << scorenow << endl;
            cout << "Press r to roll again, or h to hold." << endl;
            cin >> iSel;
        }
    }

    if(iSel == 'h')
    {
        humanTotalScore += scorenow;
    }
    return(humanTotalScore);
}

int computerTurn(int &computerTotalScore)
{
    int scorenow = 0;
    int GetPoint;

    cout << "--- Computer's total score is: " << computerTotalScore << " ---" << endl;
    while((scorenow <= 20) && (scorenow != 1))
    {
        GetPoint = Serving();
        if(GetPoint == 1)
        {
            cout << "A [1] occurred, computer's turn ended." << endl;
            break;
        }
        else
        {
            scorenow += GetPoint;
            cout << "Computer got a " << GetPoint << ". Computer's score for this turn is: " << scorenow << endl;
        }
    }
	//Keep rolling on the computer’s turn until
	//it has accumulated 20 or more points, then hold
    if(scorenow >= 20)
    {
        computerTotalScore += scorenow;
        cout << "Additional " << GetPoint << " points gained." << endl;
    }
    return(computerTotalScore);
}

int Serving()
{
    int Dice;

    Dice = (int)((rand()%6)+1); //Get a random number between 1 and 6, inclusive.

    return(Dice); //Back to caller
}
