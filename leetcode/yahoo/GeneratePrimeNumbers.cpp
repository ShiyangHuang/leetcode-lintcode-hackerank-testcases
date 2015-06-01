#include<iostream>
#include<vector>
using namespace std;

vector<int> ans;
void GeneratePrimeNumbers(int n)
{
    ans.push_back(2);
    for(int i=3;i<n;i++)
    {
        for(int j=0;j<ans.size();j++)
        {
            if(i%ans[j]==0) 
                break;
            if(j==ans.size()-1) 
                ans.push_back(i);
        }
    }
}

main()
{
    GeneratePrimeNumbers(100);
    for(int i=0;i<ans.size();i++)
    {
        cout<<ans[i]<<endl;
    }
    system("pause");
}           
