#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class StoryWordManager
{
      public:
             StoryWordManager();

             string getName();
             string getNoun();
             string getBodyPart();
             string getVerb();

             int getNumber();

             string m_Name;
             string m_Noun;
             string m_BodyPart;
             string m_Verb;

             int m_Number;

      //private:
              string m_Prompt;

              string askText();
              int askNum();


};

StoryWordManager::StoryWordManager()
{

     cout << "Welcome to the Mad-Libs game.\n\n" << endl;
     cout << "Answer the questions to help create a story:\n\n" << endl;

     m_Prompt = "name";
     m_Name = askText();

     m_Prompt = "noun";
     m_Noun = askText();

     m_Prompt = "body part";
     m_BodyPart = askText();

     m_Prompt = "verb";
     m_Verb = askText();

	 m_Prompt = "number";
     m_Number = askNum();

}

string StoryWordManager::askText()
{
       string text;
	   cout << "Please enter a " << m_Prompt << ":";
       cin >> text;
       return text;
}

int StoryWordManager::askNum()
{
    int num;
	cout << "Please enter a number:";
    cin >> num;
    return num;
}

string StoryWordManager::getName()
{
      return m_Name;
}

string StoryWordManager::getNoun()
{
      return m_Noun;
}

string StoryWordManager::getBodyPart()
{
      return m_BodyPart;
}

string StoryWordManager::getVerb()
{
      return m_Verb;
}
int StoryWordManager::getNumber()
{
      return m_Number;
}

class MadLib
{
      public:
             MadLib(StoryWordManager*);

};

MadLib::MadLib(StoryWordManager* StoryWordManagerPtr)
{

    cout << "\n\nHere's your story:\n\n";
    cout << "The famous explorer ";
    cout << (*StoryWordManagerPtr).getName();
    cout << " had nearly given up a life-long quest to find\n";
    cout << "The Lost City of ";
    cout << (*StoryWordManagerPtr).getNoun();
    cout << " when one day, the ";
    cout << (*StoryWordManagerPtr).getNoun();
    cout << " found the explorer.\n\n";
    cout << "Surrounded by ";
    cout << (*StoryWordManagerPtr).getNumber();
    cout << " " << (*StoryWordManagerPtr).getNoun();
    cout << ", a tear came to ";
    cout << (*StoryWordManagerPtr).getName() << "'s ";
    cout << (*StoryWordManagerPtr).getBodyPart() << ".\n";
    cout << "After all this time, the quest was finally over. ";
    cout << "And then, the ";
    cout << (*StoryWordManagerPtr).getNoun() << "\n";
    cout << "promptly devoured ";
    cout << (*StoryWordManagerPtr).getName() << ". ";
    cout << "\n\nThe moral of the story?... Be careful what you wish for";


}

int main()
{
    StoryWordManager userInput;
    userInput.askText();
    userInput.askNum();

	StoryWordManager *StoryWordManagerPtr;

    return(0);
}
