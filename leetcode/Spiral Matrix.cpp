#include<iostream>
#include<vector>
using namespace std;
 
vector<int> ans;
vector<int> spiralOrder(vector<vector<int> > &matrix) {
    if(matrix.size()==0) return ans;
    int left=0,right=matrix[0].size(),up=0,down=matrix.size();
    cout<<right<<" "<<down<<endl;
    while(up<down&&left<right)
    {
        for(int i=left;i<right;i++)
        {
            ans.push_back(matrix[up][i]);
            //cout<<matrix[up][i]<<"a ";
        }
        for(int i=up+1;i<down-1;i++)
        {
            ans.push_back(matrix[i][right-1]);
            //cout<<matrix[i][right-1]<<"b ";
        }
        if(down-up<=-1) break;
        for(int i=right-1;i>=left;i--)
        {
            ans.push_back(matrix[down-1][i]);
            //cout<<matrix[down-1][i]<<"c ";
        }
        if(right-left<=1) break;
        for(int i=down-2;i>up;i--)
        {
            ans.push_back(matrix[i][left]);
            //cout<<matrix[i][left]<<"d ";
        }
        up++;down--;left++;right--;
    }     
    return ans;   
}

main()
{
    vector<int> a;
    vector<vector<int> > b;
    for(int j=0;j<3;j++)
    {
        for(int i=0;i<1;i++)
        {
            a.push_back(i+j);
            //cout<<i+j<<" ";
        }
        cout<<endl;
        b.push_back(a);
    }
    vector<int> c=spiralOrder(b);
    for(int i=0;i<c.size();i++)
    {
        cout<<c[i]<<endl;
    }    
    system("pause");
    return 0;
}    
