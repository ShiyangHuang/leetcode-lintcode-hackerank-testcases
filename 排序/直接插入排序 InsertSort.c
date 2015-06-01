#include<stdio.h>

void InsertSort(int r[],int n)  //直接插入排序 
//r为存放所有记录的数组,从r[1]开始，n为记录数
{    int i,j;
     for(i=2;i<=n;i++)
     {  r[0]=r[i];  //设定r[0]为监视哨 
        j=i-1;
        while(r[0]<r[j])  //进行元素移动
        {  r[j+1]=r[j];
           j--;
        } 
        r[j+1]=r[0];   //在j+1位置处插入r[0]
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
    InsertSort(a,n);
    for(i=1;i<=n;i++)
    fprintf(op,"%d",a[i]);
    return 0;
}
    

