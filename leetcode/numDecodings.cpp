#include<iostream>
using namespace std;
int sum;
void check(string s,int k)
{
    if(k==s.length()) 
    {
        sum++;
        return;
    }
    else
    {
        if((k+1)<=s.length()&&s[k+1]!='0') check(s,k+1);
        if(s[k]=='1'&&(k+1)<s.length()) check(s,k+2);
        if(s[k]=='2'&&(k+1)<s.length()&&s[k+1]<='6') check(s,k+2);
    }    
}    


int numDecodings2(string s) {
    sum=0;
    check(s,0);
    return sum;
}


int numDecodings(string s) {
        int n=s.size();
        if(n==0)return 0;
        int *result=new int[n+1];
        memset(result,0,(n+1)*sizeof(int));
        result[0]=1;
        for(int i=1;i<=n;i++)
        {
            if(s[i-1]!='0')
            {
                result[i]+=result[i-1];
            }
            if(i>=2&&s[i-1]-'0'+10*(s[i-2]-'0')<=26&&s[i-1]-'0'+10*(s[i-2]-'0')>=10)
            {
                result[i]+=result[i-2];
            }
        }
        return result[n];
    }
    
main()
{
    cout<<numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948");
    system("pause");
}    
