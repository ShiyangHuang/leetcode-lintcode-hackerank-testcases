#include<stdio.h>

void ShellSort(int r[],int n)
{    int i,j,dk;
     dk=n/2;
     while(dk>0)
     {   for(i=dk+1;i<=n;i++)
           if(r[i]<r[i-dk])
           {  r[0]=r[i];
              j=i-dk;
              while(j>0&&r[0]<r[j])
              {  r[j+dk]=r[j];
                 j=j-dk;
              }
              r[j+dk]=r[0];
           }
           dk=dk/2;
     }
}

main()
{   FILE *ip=fopen("in.txt","r");
    FILE *op=fopen("out.txt","w");
    int a[100];
    int n,i;
    fscanf(ip,"%d",&n);
    for(i=1;i<=n;i++)
    fscanf(ip,"%d",&a[i]); 
    ShellSort(a,n);
    for(i=1;i<=n;i++)
    fprintf(op,"%d ",a[i]);
    return 0;
}
         
