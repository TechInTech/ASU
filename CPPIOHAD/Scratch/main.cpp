#include <iostream>

using namespace std;

int main()
{
    bool i = (-1 || 1 && 0);
    int x = 1;
    int z1 = 1;
while(x < 5)
    x += x;
cout << x << endl;
cout << i << endl;
int y = 1, z = 1;
for(x = 0; y < 1; z++) y++;

cout << y << endl;
x += ++z1 ;
z1 += ++z1;
cout << x << endl;
cout << z1 << endl;
return(x);

}
