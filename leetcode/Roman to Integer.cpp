#include<iostream>
using namespace std;

int romanToInt(string s) {
    int t=0,ans=0,l=s.length();
    //千位
    while(t<l&&s[t]=='M')
    {
        ans++;
        t++;
    }
    ans*=10;
    //百位
    if(t<l&&s[t]=='D') {ans+=5;t++;}
    while(t<l&&s[t]=='C')
    {
        ans++;
        t++;
        if(t<l&&s[t]=='D') {ans+=3;t++;break;}
        if(t<l&&s[t]=='M') {ans+=8;t++;break;}
    }
    ans*=10;
    //十位
    if(t<l&&s[t]=='L') {ans+=5;t++;}
    while(t<l&&s[t]=='X')
    {
        ans++;
        t++;
        if(t<l&&s[t]=='L') {ans+=3;t++;break;}
        if(t<l&&s[t]=='C') {ans+=8;t++;break;}
    }
    ans*=10;
    //个位
    if(t<l&&s[t]=='V') {ans+=5;t++;}
    while(t<l&&s[t]=='I')
    {
        ans++;
        t++;
        if(t<l&&s[t]=='V') {ans+=3;t++;break;}
        if(t<l&&s[t]=='X') {ans+=8;t++;break;}
    }
    return ans;
} 

main()
{
    string s="MCMXCVI";
    cout<<romanToInt(s)<<endl;
    system("pause");
}    
