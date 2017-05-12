#include <iostream>
#include <string>

using namespace std;

int main()
{
    //creating the variables:
    int i;
    string lineone, linetwo, linethree, linefour, linefive, linesix, lineseven, lineeight;
    string madLibArray[7] = { "Bansal", "Desiree", "hamburger", "101.5", "idiotic", "grey", "racoon"};
    string argumentArray[7] = {"the instructor's first or last name",
                               "your name",
                               "a food",
                               "a number between 100 and 120",
                               "an adjective",
                               "a color",
                               "an animal"};

    /*
    cout << "Length of array: " + 7 <<endl;
    for(i=0; i < 7; i++){
        cout <<i <<endl;
        //cout << "Please type " + argumentArray[i]  + ":" <<endl;
        //cin >> madLibArray[i];
    }
    */

    lineone = "Dear Professor ";
    lineone.append(madLibArray[0]);
    cout << lineone << ",\n\n";
    linetwo = "I am sorry that I am unable to turn in my homework at this time.";
    cout << linetwo << endl;
    linethree = "First, I ate a rotten ";
    linethree.append(madLibArray[2]);
    linethree.append(", which made me turn ");
    linethree.append(madLibArray[5]);
    linethree.append(" and");
    cout << linethree << endl;
    linefour = "extremely ill. I came down with a fever of ";
    linefour.append(madLibArray[3]);
    linefour.append(".");
    cout << linefour << endl;
    linefive = "Next, my ";
    linefive.append(madLibArray[4]);
    linefive.append(" pet ");
    linefive.append(madLibArray[6]);
    linefive.append(" must have smelled the remains");
    cout << linefive << endl;
    linesix = "of the ";
    linesix.append(madLibArray[2]);
    linesix.append(" on my homeowork, because he ate it. I am currently");
    cout << linesix << endl;
    lineseven = "rewriting my homework and hope you will accept it late.";
    cout << lineseven << endl << endl;
    lineeight = "Sincerely,";
    lineeight.append("\n\n");
    lineeight.append(madLibArray[1]);
    cout << lineeight << endl;

    return 0;
}
