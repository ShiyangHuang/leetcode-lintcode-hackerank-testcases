#include<iostream>
using namespace std;

bool isPalindrome(int x) {
    if(x<0) return false;
    if(x==0) return true;
    
    int base = 1;
    while(x/base>=10)
    {
        base*=10;
    }
    //cout<<base<<endl;
    int rbase=1;
    //cout<<x<<endl;
    while(x)
    {
        int ld=x/base;
        int rd=x%10;
        //cout<<ld<<" "<<rd<<endl;
        if(ld!=rd) return false;
        else
        {
            x-=ld*base;
            base/=100;
            x/=10;
        }
        //cout<<x<<endl;
    }        
    return true;
}
    
main()
{
    int a=101;
    cout<<isPalindrome(a)<<endl;
    system("pause");
    return 0;
}        
