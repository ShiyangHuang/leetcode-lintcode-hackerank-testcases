#include<stdio.h>

void BubbleSort(int r[],int n)
{
     int i,j;
     for(i=1;i<=n-1;i++)
       for(j=n;j>=i+1;j--)
         if(r[j]<r[j-1])
         {  r[0]=r[j];
            r[j]=r[j-1];
            r[j-1]=r[0];
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
    BubbleSort(a,n);
    for(i=1;i<=n;i++)
    fprintf(op,"%d ",a[i]);
    return 0;
} 
