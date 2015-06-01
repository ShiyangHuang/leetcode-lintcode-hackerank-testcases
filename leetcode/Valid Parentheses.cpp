#include<iostream>
using namespace std;
    bool isValid(string s) {
        if(s.size()==0) return false;
        short a[10000],i=0;
        for(int j=0;j<s.size();j++)
        {
            if(i<0) return false;
            switch(s[j]){
                case '(':
                    a[i++]=1;break;
                case ')':
                    if(a[i-1]!=1) return false;
                    else i--;break;
                case '[':
                    a[i++]=2;break;
                case ']':
                    if(a[i-1]!=2) return false;
                    else i--;break;
                case '{':
                    a[i++]=3;break;
                case '}':
                    if(a[i-1]!=3) return false;
                    else i--;break;
                default:
                    break;
                }
        }
        if(i==0) return true;
        else return false;
    }
    
main()
{
    char s[]= "([])";
    cout<<isValid(s)<<endl;
    system("pause");
}    
