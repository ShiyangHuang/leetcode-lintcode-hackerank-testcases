#include<iostream>
#include<vector>
using namespace std;

vector<vector<int> > ans;
bool find(vector<int> a,int t,int l,int r)
{
    if(l>r) return false;
    int min=(l+r)/2;
    if(a[min]==t) 
    {
        return true;
    }
    if(a[min]>t) return find(a,t,l,min-1);
    if(a[min]<t) return find(a,t,min+1,r);
}
    
vector<vector<int> > twosum(vector<int> a,int target)
{
    sort(a.begin(),a.end());
    for(int i=0;i<a.size();i++)
    {
        int t=target-a[i];
        if(find(a,t,i+1,a.size()-1))
        {
            vector<int> temp;
            temp.push_back(a[i]);
            temp.push_back(t);
            ans.push_back(temp);
        }
    }
    return ans;
}

main()
{
    vector<int> a;
    for(int i=0;i<10;i++)
    {
        a.push_back(i);
    }
    vector<vector<int> > b=twosum(a,10);
    for(int i=0;i<b.size();i++)
    {
        for(int j=0;j<2;j++)
        {
            cout<<b[i][j]<<" ";
        }
        cout<<endl;
    }       
    system("pause");
}    
