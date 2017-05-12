#include <iostream>
#include <string>

using namespace std;

class MyString
{
private:
	char *Buffer;

public:
	MyString(const char *InitialInput)
	{
		cout << "Constructor: creating new MyString" << endl;
		if(InitialInput != NULL)
		{
			Buffer = new char[strlen(InitialInput) + 1];
			strcpy(Buffer, InitialInput);
			cout << "Buffer points to: 0x" << hex;
			cout << (unsigned int) *Buffer << endl;
		}
		else
		{
			Buffer = NULL;
		}
	}

	MyString(const MyString &CopySource)
	{
		cout << "Copy constructor: copying from MyString" << endl;

		if(CopySource.Buffer != NULL)
		{
			Buffer = new char[strlen(CopySource.Buffer) + 1];
			strcpy(Buffer, CopySource.Buffer);
			cout << "Buffer points to: 0x" << hex;
			cout << (unsigned int) *Buffer << endl;
		}
		else
		{
			Buffer = NULL;
		}
	}

	~MyString()
	{
		cout << "Invoking Destructor, cleaning up" << endl;

		if(Buffer != NULL)
		{
			delete [] Buffer;
		}
	}

	int GetLength()
	{
		return(strlen(Buffer));
	}

	const char *GetString()
	{
		return(Buffer);
	}

};

void UseMyString(MyString Input)
{
	cout << "String buffer in MyString is " << Input.GetLength();
	cout << " characters long" << endl;
	cout << "Buffer contains: " << Input.GetString() << endl;
	return;
}

int main(void)
{
	MyString SayHello("Hello From String Class");
	UseMyString(SayHello);
	return(0);
}




