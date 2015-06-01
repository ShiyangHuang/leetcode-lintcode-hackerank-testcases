#include<iostream>
#include<vector>
#include<string>
using namespace std;
vector<string> ans;
char c[10];
int tn;
int maxn;
void check(int left,int right)
{
    if(left==0&&right==0)
    {
        c[maxn]='\0';
        string temp=c;
        ans.push_back(temp);
        cout<<ans[tn++]<<endl;
    }    
    if(left>0)
    {
        c[maxn-left-right]='(';
        check(left-1,right);
    }    
    if(right>0&&left<right)
    {
        c[maxn-left-right]=')';
        check(left,right-1);
    }    
}
vector<string> generateParenthesis(int n) {
    maxn=n*2;
    tn=0;
    check(n,n);  
    return ans; 
}
main()
{
    int n=3;
    vector<string> output=generateParenthesis(n);
    system("pause");
    return 0;
}        
