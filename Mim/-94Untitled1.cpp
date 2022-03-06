#include<bits/stdc++.h>
using namespace std;
int main()
{
    char s[100];
    int c=0,i=0;
    cin>>s;
    while(s[i]!='1')
        i++;
    for(;s[i]!='\0';i++)
    {
        if(s[i]=='0')
            c++;
    }
    if(c>=6)
        cout<<"yes";
    else
        cout<<"no";

    return 0;
}
