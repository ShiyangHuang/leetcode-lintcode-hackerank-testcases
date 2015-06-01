#include<iostream>
#include<vector>
using namespace std;


vector<vector<int> > generateMatrix(int n) {
    vector<vector<int> > ans;
    vector<int> temp;
    for(int i=0;i<n;i++)
    {
        temp.push_back(1);
    }
    for(int i=0;i<n;i++)
    {
        ans.push_back(temp);
    }
    if(n==1) return ans;
    
    int t=1;
    int left=0,right=n,up=0,down=n;
    //cout<<right<<" "<<down<<endl;
    while(up<down&&left<right)
    {
        if(t>n*n) break;
        for(int i=left;i<right;i++)
        {
            ans[up][i]=t;
            t++;
            //cout<<matrix[up][i]<<"a ";
        }
        if(t>n*n) break;
        for(int i=up+1;i<down-1;i++)
        {
            ans[i][right-1]=t;
            t++;
            //cout<<matrix[i][right-1]<<"b ";
        }
        if(t>n*n) break;
        if(down-up<=-1) break;
        for(int i=right-1;i>=left;i--)
        {
            ans[down-1][i]=t;
            t++;
            //cout<<matrix[down-1][i]<<"c ";
        }
        if(t>n*n) break;
        if(right-left<=1) break;
        for(int i=down-2;i>up;i--)
        {
            ans[i][left]=t;
            t++;
            //cout<<matrix[i][left]<<"d ";
        }
        up++;down--;left++;right--;
    }
    return ans;    
}
   
   

main()
{
    int n=3;
    vector<vector<int> > c=generateMatrix(n);
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout<<c[i][j]<<" ";
        }
        cout<<endl;
    }        
    
    system("pause");
    return 0;
}    
