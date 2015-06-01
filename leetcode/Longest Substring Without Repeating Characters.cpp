#include<iostream>
using namespace std;

int lengthOfLongestSubstring(string s) {
    short hash[256];
    memset(hash,0,sizeof(hash));
    int i=0,j=0,ans=1,n=s.size();
    if(n==0) return 0;
    while(j<n)
    {
        char c = s[j];
        if(hash[c]==0)
        {
            j++;
            hash[c]++;
        }
        else
        {
            if(ans<j-i)
               ans = j-i;
            char cc = s[i];
            hash[cc]--;
            i++;
        }   
    }
    if(ans<j-i)
       ans = j-i;
    return ans;        
}

main()
{
    cout<<lengthOfLongestSubstring("abcdefghijklmnbopqrstuvwxyz");
    system("pause");
}    
