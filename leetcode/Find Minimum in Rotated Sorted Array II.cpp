#include<iostream>
#include<vector>
using namespace std;

int findMax(vector<int> &num,int l,int r)
{
    int min=(l+r)/2;;
    if(num[r]<num[l])
    {
        if(num[min]>=num[l]) return findMax(num,min,r-1);
        else return findMax(num,l,min-1);
    }
    else return min;
}        
int findMin(vector<int> &num) {
    int max = findMax(num,0,num.size()-1);
    //return max;
    while(max+1<num.size()&&num[max+1]>=num[max])
    {
        max++;
    }
    if(max+1=num.size()) return 0;
    else return max+1;
}

main()
{
    vector<int> a;
    for(int i=0;i<1;i++)
    {
        for(int j=0;j<3;j++)
        a.push_back(i);
    }
    for(int i=-5;i<0;i++)
    {
        a.push_back(i);
    }
    for(int i=0;i<a.size();i++)
    {
        cout<<a[i]<<" ";
    }cout<<endl;    
    cout<<findMin(a)<<endl;
    system("pause");
}    
