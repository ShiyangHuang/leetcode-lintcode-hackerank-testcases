#include<iostream>
#include<vector>
using namespace std;

vector<int> ans;
vector<vector<int> > rans;
bool bs(vector<int> &num, int l,int r,int x)
{
    if(l>r) return false;
    int min=(l+r)/2;
    if(num[min]==x)
    {
        ans.push_back(num[min]);
        return true;
    }
    else if(l>=r) return false;
    if(x>num[min])
        return bs(num,min+1,r,x);
    else
        return bs(num,l,min-1,x);
}    
    
vector<vector<int> > threeSum(vector<int> &num) {
    int n=num.size();
    sort(num.begin(),num.end());
    for(int i=0;i<n-2;i++)
    {
        if(i==0||num[i]!=num[i-1])
        {
            ans.push_back(num[i]);
            for(int j=i+1;j<n-1;j++)
            {
                if(j==i+1||num[j]!=num[j-1])
                {
                   ans.push_back(num[j]);
                   if(bs(num,j+1,n-1,0-ans[0]-ans[1]))
                   {
                       cout<<"1:"<<ans[0]<<" 2:"<<ans[1]<<" 3:"<<ans[2]<<endl;
                       rans.push_back(ans);
                       ans.pop_back();
                   }
                   ans.pop_back();
                }    
            }
        ans.pop_back();
        }    
    }            
    return rans;         
}

main()
{
    int iarray[]={-2,0,0,2,2};
    vector<int> a(iarray,iarray+(sizeof(iarray)/sizeof(int)));
    vector<vector<int> > b=threeSum(a);
    for(int i=0;i<b.size();i++)
    {
        for(int j=0;j<b[i].size();j++)
        {
            cout<<b[i][j]<<" ";
        }
        cout<<endl;
    }
    system("pause");        
    
}    
