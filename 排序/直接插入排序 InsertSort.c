#include<stdio.h>

void InsertSort(int r[],int n)  //ֱ�Ӳ������� 
//rΪ������м�¼������,��r[1]��ʼ��nΪ��¼��
{    int i,j;
     for(i=2;i<=n;i++)
     {  r[0]=r[i];  //�趨r[0]Ϊ������ 
        j=i-1;
        while(r[0]<r[j])  //����Ԫ���ƶ�
        {  r[j+1]=r[j];
           j--;
        } 
        r[j+1]=r[0];   //��j+1λ�ô�����r[0]
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
    

