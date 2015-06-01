#include<iostream>
#include<vector>
using namespace std; 

int maxProfit(vector<int> &prices) {
    int n=prices.size();
    int sum=0;
    for(int i=0;i<n;i++)
    {
        int j=i+1;
        while(j<n&&prices[j]>prices[j-1])
        {
            j++;
        }
        j--;
        cout<<prices[j]<<" "<<prices[i]<<endl;
        sum+=prices[j]-prices[i];
        i=j;
    }
    return sum;    
}

main()
{
    vector<int> a;
    for(int i=0;i<10;i++)
    {
        int j=rand()%10;
        cout<<j<<" ";
        a.push_back(j);
    }
    cout<<endl;
    cout<<maxProfit(a);
    system("pause");
}        
