/*
		Write a program that plays the game of Mad Lib. The program should prompt the user to
		enter the following strings:
		• The first or last name of your Instructor
		• Your name
		• A food
		• A number between 100 and 120
		• An adjective
		• A color
		• An animal

		After getting the strings as input, they should be substituted into the story below. The
		resulting story should be displayed as the output.

		Dear Professor [Instructor Name],
		I am sorry that I am unable to turn in my homework at this time.
		First, I ate a rotten [Food], which made me turn [Color] and
		extremely ill. I came down with a fever of [Number 100-120].
		Next, my [Adjective] pet [Animal] must have smelled the remains
		of the [Food] on my homework, because he ate it. I am currently
		rewriting my homework and hope you will accept it late.
		Sincerely,
		[Your Name]

		Programmer: Hieu Pham
		ASUID:		0953-827
		SER221
		FALL B, 2015
*/

//Bring in supporting functions
//for IString, cin, and cout
#include <iostream>
#include <string>
using namespace std;

struct TheString
{
    char IString[100];
};

int main(void)
{

    	TheString TSData[7];

    	cout << "\n Enter your instructor's last name: ";
        cin >> TSData[0].IString;
        cout << "\n Enter your first name: ";
        cin >> TSData[1].IString;
        cout << "\n Enter a food item: ";
        cin >> TSData[2].IString;
        cout << "\n Enter a number between 100 and 120: ";
        cin >> TSData[3].IString;
        cout << "\n Enter an adjective: ";
        cin >> TSData[4].IString;
        cout << "\n Enter a color: ";
        cin >> TSData[5].IString;
        cout << "\n Enter an animal: ";
        cin >> TSData[6].IString;

        cout << "\n\n";
        cout << "\nDear Professor " << TSData[0].IString << ",\n";
        cout << "\nI am sorry that I am unable to turn in my homework at this time.\n";
        cout << "First I ate a rotten " << TSData[2].IString << ", which made me turn " << TSData[5].IString << " and " << endl;
        cout << "extremely ill. I came down with a fever of " << TSData[3].IString << "." << endl;
        cout << "Next, my " << TSData[4].IString << " pet " << TSData[6].IString << " must have smelled the remains" << endl;
        cout << "of the " << TSData[2].IString << " on my homework, because he ate it. I am currently" << endl;
        cout << "rewriting my homework and hope you will accept it late." << endl;
        cout << "\n\n";
        cout << "Sincerely," << endl;
        cout << TSData[1].IString << endl;

        return(0);
}
