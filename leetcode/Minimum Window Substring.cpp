#include<iostream>
using namespace std;

string minWindow(string S, string T) {
    int l=0,r=0;
    int flag[150]={false};
    int n=0;
    for(int i=0;i<T.size();i++)
    {
        if(!flag[T[i]])
        {
            flag[T[i]]=true;
            n=0;
        }
    }
    int nn=0;
    int flag2[150]={false};
    while(r<S.size()&&nn<n)
    {
        if(flag[S[r]]) 
        {
            flag2[S[r]]=true;
            nn++;
        }
        r++;
    }
    
        
    
} 
