#include<iostream>
using namespace std;

int trap(int A[], int n) {
    int sum=0;
    int maxn=0,max=0;
    for(int i=0;i<n;i++)
    {
        if(A[i]>max)
        {
            max=A[i];
            maxn=i;
        }
    }
    cout<<"max="<<max<<" maxn="<<maxn<<endl;
    for(int i=0;i<maxn;i++)
    {
        int subsum=0;
        for(int j=i+1;j<=maxn;j++)
        {
            if(A[j]>=A[i]) 
            {
                sum+=subsum;
                i=j-1;
                break;
            }
            else
            subsum+=A[i]-A[j];
        }
    }
    for(int i=n-1;i>maxn;i--)
    {
        int subsum=0;
        for(int j=i-1;j>=maxn;j--)
        {
            if(A[j]>=A[i]) 
            {
                sum+=subsum;
                i=j+1;
                break;
            }
            else
            subsum+=A[i]-A[j];
        }
    }
    return sum;    
}

main()
{
    int a[]={4,2,0,3,2,4,3,4};
    cout<<trap(a,(sizeof(a)/sizeof(int)));
    system("pause");
}    
