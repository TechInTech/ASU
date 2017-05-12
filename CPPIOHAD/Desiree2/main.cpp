#include <iostream>
#include <string>
using namespace std;

int main()
{
   char wannaquit;
   char theinput, p1input, p2pinput;
   int p1score = 0;
   int p2score = 0;

    do
    {
        //Prompting 'Player1' to enter "r", "s", or "p" (case INsensitive):
        cout << "Player 1, please enter (R)ock, (P)aper, or (S)cissors: " <<endl;
       //Retrieving 'Player1' response:
        cin >> theinput;
        p1input = tolower(theinput);

       //Prompting 'Player2' to enter "r", "s", or "p" (case INsensitive):
        cout << "Player 2, please enter (R)ock, (P)aper, or (S)cissors: " <<endl;
       //Retrieving 'Player2' response:
        cin >> theinput;
        p2pinput = tolower(theinput);

       //checking to see who won based on each player's response:
        if((p1input == 'r' && p2pinput == 's') || (p1input == 'p' && p2pinput == 'r') || (p1input == 's' && p2pinput == 'p'))
        {
           cout << "Player 1 wins!" << endl;
           p1score++;
        }
        else
        if(p1input==p2pinput)
        {
           cout << "It's a draw!" << endl;
        }
        else
        {
           cout << "Player 2 wins" << endl;
           p2score++;
        }


        cout << "Score so far:\n Player 1:" << p1score << "\nPlayer 2: " << p2score <<endl;
        cout << "Would you like to continue playing?" <<endl;
        cin >> theinput;
        wannaquit = tolower(theinput);
    }while((wannaquit == 'y')||(wannaquit == 'Y'));


   cout << "Bye for now!" <<endl;

   return 0;
}
