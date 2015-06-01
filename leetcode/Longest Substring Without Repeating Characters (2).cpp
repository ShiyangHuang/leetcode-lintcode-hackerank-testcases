#include<iostream>
using namespace std;

    int lengthOfLongestSubstring(string s) {
        bool c[300];
        memset(c,true,sizeof(c));
        int i=0, max = 0;
        for(int j=0;j<s.length();j++)
        {
            while(!c[s[j]]){
                c[s[i]]=true;
                i++;
            }
            c[s[j]]=false;
            if(max<j-i) max=j-i;
        }             
        return max+1;
    }
    
    main()
    {
        string s;
        cout<<lengthOfLongestSubstring("eee");
        system("pause");
    }     
