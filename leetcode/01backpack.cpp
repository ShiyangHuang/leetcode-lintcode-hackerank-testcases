#include<iostream>
using namespace std;
int max(int a,int b)
{
    return a>b?a:b;
}

main()
{
      int f[50][50]={0};
      int a[10] = {1,3,4,2,7,5,6,11,9};
      int n=10,s=20;
      for(int i=1;i<=n;i++)
        for(int j=0;j<=s;j++)
        {
            if(j-a[i]>=0)
            f[i][j]=max(f[i-1][j],f[i-1][j-a[i]]+a[i]);
            else
            f[i][j]=f[i-1][j];
        }
      cout<<f[n][s]<<endl;
      system("pause");
      
      
}
