#include <iostream>
#include <vector>
using namespace std;
vector<vector<int> > ans;
    vector<int> subans;
    vector<vector<int> > threeSum(vector<int> &num) {
        sort(num.begin(),num.end());
        for(int i=0;i<3;i++)
        subans.push_back(i);
        int n=num.size();
        for(int i=0;i<n;i++)
        {
            subans[0]=num[i];
            int j=i+1,k=n-1;
            while(j<k)
            {
                if(num[i]+num[j]+num[k]==0) 
                {
                    subans[1]=num[j];
                    subans[2]=num[k];
                    ans.push_back(subans);
                    j++;k--;
					while(j<n&&num[j]==num[j-1]) j++;
					while(k>i&&num[k]==num[k+1]) k--;
                }
                else if(num[i]+num[j]+num[k]>0)
                {
                    k--;
                }
                else j++;
            }
			while(i<n-1&&num[i+1]==num[i]) i++;
        }
        return ans;
    }

int main(int argc, char *argv[]) {
	vector<int> a;
	int s[] = {-1, 0, 1, 2, -1, -4};
	for(int i=0;i<6;i++)
		a.push_back(s[i]);
	vector<vector<int> > aa = threeSum(a);
	for(int i=0;i<aa.size();i++)
	{
		for(int j=0;j<3;j++)
		{
			cout<<aa[i][j]<<" ";
		}
		cout<<endl;
	}
}