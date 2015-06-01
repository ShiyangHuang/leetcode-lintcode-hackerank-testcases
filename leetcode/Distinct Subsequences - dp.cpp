#include<iostream>
#include<vector>
using namespace std;
int ans;
int maxs,maxt;

int numDistinct(string S, string T) {
    maxs=S.length();
    maxt=T.length();
    vector<vector<int> > dp(maxs+1, vector<int>(maxt+1, 0));


    for(int i=0;i<=maxs;i++)
    {
        dp[i][0]=1;
    }
    
    for(int i=1;i<=maxs;i++){
        for(int j=1;j<=maxt;j++){
            dp[i][j]=dp[i-1][j];
            if(S[i-1]==T[j-1]) 
                dp[i][j]+=dp[i-1][j-1];
        }
    }        
    return dp[maxs][maxt];
}
main()
{
    string S="b";
    string T="a";
    cout<<S.length()<<endl; 
    cout<<T.length()<<endl; 
    cout<<numDistinct(S,T);
    system("pause");
}   

 
