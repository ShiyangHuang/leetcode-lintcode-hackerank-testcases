#include<iostream>
#include<vector>
using namespace std;

vector<int> RemoveDuplicates(vector<int> a)
{
    vector<int> ans;
    int t=0;
    if(a.size()==0) return ans;
    ans.push_back(a[0]);
    for(int i=1;i<a.size();i++)
    {
        if(a[i]!=ans[t])
        {
            ans.push_back(a[i]);
            t++;
        }
    }
    return ans;
}

main()
{
    vector<int> a;
    for(int i=0;i<10;i++)
    {
        int t=rand()%4;
        for(int j=0;j<t;j++)
        {
            a.push_back(i);
        }
    }
    vector<int> b=RemoveDuplicates(a);
    for(int i=0;i<b.size();i++)
    {
        cout<<b[i]<<endl;
    }
    system("pause");
}                          
