#include<iostream>
using namespace std;

void merge(int A[], int m, int B[], int n) {
    int mi=m-1,ni=n-1;
    int max=m+n-1;
    while(max>=0)
    {
        if(mi>=0&&A[mi]>B[ni]) A[max--]=A[mi--];
        else if(ni>=0) A[max--]=B[ni--];
        else {break;}
    }
    if(ni>=0)
        while(max>=0)
        {
            A[max--]=B[ni--];
        }
    for(int i=0;i<m+n;i++)
    {
        cout<<A[i]<<endl;
    }        
}

main()
{
    int a[]={};
    int b[]={1,2,3};
    merge(a,0,b,3);
    system("pause");
}    
