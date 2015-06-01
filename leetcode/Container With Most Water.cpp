int max(int a,int b)
{
    return (a>b?a:b);
}

int min(int a,int b)
{
    return (a<b?a:b);
}

int maxArea(int height[], int n) {
    int maxarea=0,i=0,j=n-1;
    while(i<j)
    {
        maxarea = max(maxarea,min(height[j],height[i])*(j-i));
        if(height[i]<height[j]) i++;
        else j--;
    }    
    return maxarea;        
}
