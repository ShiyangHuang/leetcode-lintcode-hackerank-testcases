#include<iostream>
using namespace std;

string convert(string s, int nRows) {
    string ans="";
    if(nRows==0) return ans;
    if(nRows==1) return s;
    int l=s.length();
    int t=0;
    while(t<l)
    {
        ans+=s[t];
        t+=nRows*2-2;
    }
    if(nRows>2)
    for(int i=1;i<nRows-1;i++)
    {
        t=i;
        while(t<l)
        {
            ans+=s[t];
            if(t+(nRows*2-2-i*2)<l)
                ans+=s[t+(nRows*2-2-i*2)];
            //cout<<s[t]<<" "<<s[t+(nRows*2-2-i*2)]<<endl;
            t+=nRows*2-2;
        }
    }
    t=nRows-1;
    if(nRows>1)
    while(t<l)
    {
        ans+=s[t];
        t+=nRows*2-2;
    }
    return ans;
}

main()
{
    string s="asdfasdf";
    cout<<convert(s,2)<<endl;
    system("pause");
}    
