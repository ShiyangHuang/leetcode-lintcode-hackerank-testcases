#include<stdio.h>

void QuickSort(int r[],int s,int t)
{
     int low=s,high=t;
     r[0]=r[s];
     while(low<high)
     {  while(high>low&&r[0]<r[high])
            high--;
        if(low<high)
        {   r[low]=r[high];
            low++;}
        while(low<high&&r[low]<=r[0])
            low++;
        if(low<high)
        {   r[high]=r[low];
            high--;}
     }
     r[low]=r[0];
     if(s<low)
        QuickSort(r,s,high-1);
     if(low<t)
        QuickSort(r,high+1,t);
}

main()
{   FILE *ip=fopen("asdf.in","r");
    FILE *op=fopen("asdf.out","w");
    int a[100];
    int n,i;
    fscanf(ip,"%d",&n);
    for(i=1;i<=n;i++)
    fscanf(ip,"%d",&a[i]); 
    QuickSort(a,1,n);
    for(i=1;i<=n;i++)
    fprintf(op,"%d ",a[i]);
    return 0;
} 
        
            
     
