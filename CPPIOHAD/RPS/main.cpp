/*
		Write a program to score the paper-rock-scissor game. Each of the two players type in either
		P, R, or S. The program then announces the winner based on the rule: Paper covers Rock,
		Rock breaks Scissors, Scissors cut Paper, or Nobody wins. Be sure to allow the players to
		use lowercase as well as uppercase letters. Your program should allow the users to play
		repeatedly until they say they are done. Your program should also keep a score for each
		player and display that after each play.
		Sample run:
		Player 1: Please enter either (R)ock, (P)aper, or (S)cissors: P
		Player 2: Please enter either (R)ock, (P)aper, or (S)cissors: s
		Player 2wins.
		Scores after this play: Player 1: 0
		Player 2: 1
		Thanks!!
		Play again? Y/y continues, other quits: n

		Programmer: Hieu Pham
		ASUID:		0953-827
		SER221
		FALL B, 2015

*/

//Bring in standard I/O functions
//including math (random()) and some other
//standard libraries to be used throughout the program
#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;

int main(void)
{
    // Variable for the do/while loop.
    // ch2 is for computer player
    char ch = '\0';  //For player1
    char ch2 = '\0'; //For player2

    // Variables needed for the scores
    int win = 0;
    int tie = 0;
    int lose = 0;
    int win2 = 0;
    int tie2 = 0;
    int lose2 = 0;

    // Beginning of game loop, the loop will terminate when (ch is neither Y nor y)
    do
    {
        char iSel;

        cout << "-----------SER221 - Week 1------------" << endl;
        cout << "---    Rock, Paper, Scissors Game  ---" << endl;
        cout << "--------------------------------------" << endl;
        // Prompt the player to enter his/her choice
        cout << "Please enter either (R)ock, (P)aper, or (S)cissors:" << endl;
        cin >> iSel;
        int hi = 0; //hi = human intelligence
        switch(iSel) //Assign some integer values
        {
            case 'r':
            case 'R':
                    hi = 1;
                    break;
            case 'p':
            case 'P':
                    hi = 2;
                    break;
            case 's':
            case 'S':
                    hi = 3;
                    break;
            default:
                    break;
        }
        // CI = artificial intelligence
        int CI = (rand() % 3 + 1); //Give it a random iSel between 1 and 3
        switch(CI) //Assign some char values
        {
            case 1:
                    ch2 = 'R';
                    break;
            case 2:
                    ch2 = 'P';
                    break;
            case 3:
                    ch2 = 'S';
                    break;
            default:
                    break;
        }
        cout <<  "Player2 chose: " << ch2 << endl;
        if(hi == 1 && CI == 1)
        {
             cout << "Rock = Rock, it's a tie!" << endl;
             tie++;
        }
        else
        if(hi == 1 && CI== 2)
        {
             cout << "Rock is covered by Paper, player2 wins!" << endl;
             lose++;
        }
        else
        if(hi == 1 && CI == 3)
        {
             cout << "Rock breaks Scissors, player1 wins!" << endl;
             win++;
        }
        else
        if(hi == 2 && CI == 1)
        {
             cout << "Paper covers Rock, player1 wins!" << endl;
             win++;
        }
        else
        if(hi == 2 && CI == 2)
        {
             cout << "Paper = Paper, it's a tie!" << endl;
             tie++;
        }
        else
        if(hi == 2 && CI == 3)
        {
             cout << "Paper is cut by Scissors, player2 wins!" << endl;
             lose++;
        }
        else
        if(hi == 3 && CI == 1)
        {
             cout << "Rock breaks Scissors, player2 wins!" << endl;
             lose++;
        }
        else
        if(hi == 3 && CI == 2)
        {
             cout << "Scissors cut Paper, player1 wins!" << endl;
             win++;
        }
        else
        if(hi == 3 && CI == 3)
        {
             cout << "Scissors = Scissors, it's a tie!" << endl;
             tie++;
        }

        // this is what happens if the player doesn't hit R,r,  P,p, or S,s
        else
        {
             cout << "You must enter (R, or r), (P or p), or (S or s)" << endl;
        }

         win2 = lose; tie2 = tie; lose2 = win;
         cout << "\nScores after this play:\n" << endl;
         cout << "\n---Player1---" << endl;
         cout << "Wins: " << win << endl;
         cout << "Ties:" << tie << endl;
         cout << "Losses:" << lose << endl;
         cout << "\n---Player2---" << endl;
         cout << "Wins: " << win2 << endl;
         cout << "Ties:" << tie2 << endl;
         cout << "Losses:" << lose2 << endl;
         cout << "\n\nThanks!!" << endl;
         cout << "\nPlay again? Y/y to continue, N/n to quit: " << endl;
         cin >> ch;
    }while((ch == 'Y') || (ch == 'y')); //Loop while this condition is true
    return(0);
}
