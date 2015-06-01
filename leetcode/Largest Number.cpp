#include<iostream>
#include<vector>
using namespace std;

string largestNumber(vector<int> &num) {
    vector<string> str;
    sort(num.begin(),num.end());
    for(int i=0;i<num.size();i++)
    {
        char c[100];
        itoa(num[i],c,10);
        str.push_back(c);
    }
    sort(str.begin(),str.end());
    string ans;
    for(int i=0;i<str.size();i++)
    {
        ans+=str[i];
    }    
    return ans;    
}

main()
{
    vector<int> num;
    for(int i=1;i<100;i++)
    {
        num.push_back(i);
    }
    cout<<largestNumber(num);
    system("pause");
}         
