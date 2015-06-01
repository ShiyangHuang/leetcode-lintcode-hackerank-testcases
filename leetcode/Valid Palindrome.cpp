#include<iostream>
using namespace std;
char isChar(char c){
    if(c >= 'a' && c<= 'z')
        return c;
    else if(c>= 'A' && c<= 'Z')
        return c-'A'+'a';
    else if(c>='0' && c<= '9')
        return c;
    else
    return 0;
}    
bool isPalindrome(string s) {
    int i=0,j=s.size();
    while(i<j)
    {
        while(!isChar(s[i])&&i<j)
          i++;
        while(!isChar(s[j])&&j>i)
          j--;
        if(isChar(s[i])!=isChar(s[j]))
          return false;
        else
        {
            i++;
            j--;
        }
    }        
    return true;
}

main()
{
    cout<<isPalindrome("1a2");
    system("pause");
}    
