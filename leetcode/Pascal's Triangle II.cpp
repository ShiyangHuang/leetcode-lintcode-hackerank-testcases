#include<iostream>
#include<vector>
using namespace std;

vector<int> getRow(int rowIndex) {
    vector<int> ans;
    rowIndex--;
    ans.push_back(1);
    if(rowIndex==-1) return ans;
    ans.push_back(1);
    int n=2;
    while(rowIndex--)
    {
        
        ans.push_back(1);
        for(int i=n-1;i>0;i--)
        ans[i]=ans[i]+ans[i-1];
        n++;
    }
    for(int i=0;i<n;i++)
      cout<<ans[i]<<" ";
    return ans;    
}

main()
{
    vector<int> c=getRow(1);
    system("pause");
}    
