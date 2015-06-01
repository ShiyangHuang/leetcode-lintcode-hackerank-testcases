#include<iostream>
using namespace std;

int singleNumber(int A[], int n) {
    short bit[34] = {0};
    long long a;
    long long mi = 0;
    for(int i=0;i<n;i++)
    {
        //cout<<A[i]<<endl;
        long long aa = (long long)A[i];
        if(aa<0)
        {
            mi+=1;
            mi %= 3;
            aa*=-1;
        }
        int j=0;
        while(aa>0)
        {   
            bit[j] += aa%2;
            bit[j] %= 3;
            aa/=2;
            //cout<<j<<" "<<bit[i]<<endl;
            j++;
        }
        //cout<<endl;
    }
    for(int i=0;i<33;i++)
    {
        
    }    
    long long j=1;
    a=0;
    for(int i=0;i<33;i++)
    {
        if(bit[i]!=0) a+=j;
        j*=2;
        //cout<<"a="<<a<<"; bit["<<i<<"]="<<bit[i]<<endl;
    }
    if(mi !=0) mi = -1;
        else mi = 1;
    return a*mi;
}

main()
{
    int a[] = {-2147483648};
    int n = sizeof(a)/sizeof(int);
    int tmp;
    for(int i=0;i<n;i++)
        for(int j=0;j<i;j++)
        {
            if(a[i]>a[j])
            {
                tmp = a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }        
    cout<<singleNumber(a,n)<<endl;
    system("pause");
}

