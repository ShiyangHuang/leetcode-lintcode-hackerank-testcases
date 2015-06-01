#include<iostream>
using namespace std;
int max(int a,int b)
{
    return a>b?a:b;
}    
int maxSubArray(int A[], int n) {
    int maxn=A[0];
    int sum=A[0];
    for(int i=0;i<n;i++)
    {
        sum = max(sum+A[i],A[i]);
        maxn = max(maxn,sum);
    }    
    return maxn;   
}

