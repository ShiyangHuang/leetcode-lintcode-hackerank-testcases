#include<iostream>
#include<vector>
using namespace std;
int main()
{
	int n=100;
        string tmp,ans;
        while(n>0)
        {
            tmp+=(char)(n%26+'A');
            n/=26;
        }
        for(int i=tmp.length()-1;i>=0;i++)
        {
            ans+=tmp[i];
        }
	cout<<ans<<endl;
}
