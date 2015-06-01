#include<iostream>
#include<vector>
using namespace std;

vector<vector<int> > ans;
vector<int> subans;

void check(vector<int> &candidates, int target, int sum, int x)
{
    if(sum==target) 
    {
        ans.push_back(subans);
    }
    for(int i=x;i<candidates.size();i++)
    if(sum+candidates[i]<=target) 
    {
        subans.push_back(candidates[i]);
        check(candidates,target,sum+candidates[i],i);
        subans.pop_back();
    }
}        
    
vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
    sort( candidates.begin() , candidates.end() );
    check(candidates,target,0,0);
    return ans;   
}

main()
{
    vector<int> a;
    for(int i=10;i>0;i--)
    {
        a.push_back(i);
    }
    vector<vector<int> > test = combinationSum(a,10);
    for(int i=0;i<test.size();i++)
    {
        for(int j=0;j<test[i].size();j++)
        {
            cout<<test[i][j]<<" ";
        }
        cout<<endl;
    }
    system("pause");
}            
