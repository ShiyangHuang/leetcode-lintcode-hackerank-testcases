#include<iostream>
using namespace std;
int ans;
int maxs,maxt;
void search(string S,string T,int x,int y)
{
    if(y>=maxt-1) 
    {
        ans++;
        return;
    }    
    for(int i=x;i<maxs;i++)
    {
        if(S[i]==T[y])
        search(S,T,i+1,y+1);
    }
}    
int numDistinct(string S, string T) {
    maxs=S.length();
    maxt=T.length();
    search(S,T,0,0);
    return ans;
}
main()
{
    string S="aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
    string T="bddabdcae";
  
    cout<<numDistinct(S,T);
    system("pause");
}    
