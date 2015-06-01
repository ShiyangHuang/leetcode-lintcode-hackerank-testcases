#include<stdio.h>

void SelectionSort(int r[],int n)
{
     int i,j,k;
     for(i=1;i<=n-1;i++)
     {  k=i;
        for(j=i+1;j<=n;j++)
           if(r[j]<r[k])
              k=j;
           if(k!=i)
           {  r[0]=r[i];
              r[i]=r[k];
              r[k]=r[0];
           }
     }
}

main()
{   FILE *ip=fopen("asdf.in","r");
    FILE *op=fopen("asdf.out","w");
    int a[100];
    int n,i;
    fscanf(ip,"%d",&n);
    for(i=1;i<=n;i++)
    fscanf(ip,"%d",&a[i]); 
    SelectionSort(a,n);
    for(i=1;i<=n;i++)
    fprintf(op,"%d ",a[i]);
    return 0;
}
           
