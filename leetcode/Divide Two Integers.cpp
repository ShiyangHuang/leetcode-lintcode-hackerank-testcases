#include<iostream>
using namespace std;
int divide(int dividend, int divisor) {
    
    long long count = 1,ans = 0,flag = 1;
    long long tmpa = dividend,tmpb = divisor;
    if(tmpa<0)
    {
        flag *= -1;
        tmpa*=-1;
    }
    if(tmpb<0)
    {
        flag *= -1;
        tmpb*=-1;
    }
    if(tmpb>tmpa) return 0;
    while(tmpa>=tmpb)
    {
        if(tmpa-tmpb*count>=0)
        {
            tmpa = tmpa-tmpb*count;
            ans += count;
            count*=2;
        }
        else
        {
            count = 1;
        }
    }
    return ans*flag;   
}

main()
{
    cout<<divide(-2,-2);
    system("pause");
}    
