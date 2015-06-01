#include<iostream>
using namespace std;

int atoi2(const char *str) {
    int flag = 1;
    int n=0;
    long ans=0;
    while(str[n]!='\0')
    {
        
        if(str[n]=='-') 
        {   flag=-1;cout<<"xxx"<<flag<<endl;}
        if(str[n]<='9'&&str[n]>='0')
        {
            ans*=10;
            ans+=(str[n]-'0')*flag;
        }
        //cout<<flag<<endl;
        n++;
    }    
    //cout<<flag<<endl;    
    return ans;        
}

main()
{
    char c[11]={"-1"};
    int t=atoi2(c);
    cout<<t<<endl;
    system("pause");
}    
