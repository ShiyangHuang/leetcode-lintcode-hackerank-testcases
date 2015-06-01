#include<iostream>
#include<vector>
using namespace std;
string longestCommonPrefix(vector<string> &strs) {
    int n=strs.size();
    string ans="";
    if(n==0) return ans; 
    int minl=strs[0].length();
    for(int i=0;i<n;i++)
    {
        if(strs[i].length()<minl) minl=strs[i].length();
    }
    int t=0;
    for(int i=0;i<minl;i++)
    {
        for(int j=1;j<n;j++)
        {
             if(strs[j][i]!=strs[0][i]) return ans;
        }
        ans+=strs[0][i];
    }    
    return ans;
}

main()
{
    vector<string> s;

    cout<<longestCommonPrefix(s)<<endl;
    system("pause");
}    
