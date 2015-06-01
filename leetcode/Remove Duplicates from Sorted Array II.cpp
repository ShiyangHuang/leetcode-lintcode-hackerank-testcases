#include<iostream>
using namespace std;

int removeDuplicates(int A[], int n) {
     int ans=0;
    int count=1;
    int k=0;
    for(int i=1;i<n;i++)
    {
        if(A[k]!=A[i]) 
        {
            count=1;
            k++;
            A[k]=A[i];
        }    
        else 
        {
            count++;
        if(count>2) ans++;
        else {
            k++;
            A[k]=A[i];
            }    
        }    
    }
    for(int i=0;i<(n-ans);i++)
    {
        cout<<A[i]<<" ";
    }    
    return n-ans;            
}

main()
{
    int a[6]={1,1,1,1,3,3};
    cout<<removeDuplicates(a,6);
    system("pause");
}    
