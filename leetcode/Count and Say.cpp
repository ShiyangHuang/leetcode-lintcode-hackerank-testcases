#include<iostream>
#include<string>
using namespace std;

string countAndSay(int n) {
    n--;
    string s1,s2;
    s1="1";
    s2="";
    while(n--)
    {
        int length=s1.length();
        int i=0;
        while(i<length)
        {
            char c=s1[i];
            int count=0;
            while(s1[i]==c&&i<length)
            {
                count++;
                i++;
            }
            s2+=char(count+'0');
            s2+=c;
        }
        s1=s2;
        s2="";
    }    
    return s1;           
}
main()
{
    for(int i=1;i<10;i++)
    cout<<countAndSay(i)<<endl;
    system("pause");
}    
