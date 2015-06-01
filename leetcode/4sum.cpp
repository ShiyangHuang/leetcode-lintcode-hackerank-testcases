#include <iostream>
#include <vector>
using namespace std;
vector<int> subans;
vector<vector<int> > ans;

vector<vector<int> > fourSum(vector<int> &num, int target) {
	sort(num.begin(),num.end());
	for(int i=0;i<4;i++)
		subans.push_back(0);
	int n=num.size();
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			int k=j+1,l=n-1;
			while(k<l)
			{
				if(num[i]+num[j]+num[k]+num[l]==target){
					subans[0]=num[i];
					subans[1]=num[j];
					subans[2]=num[k];
					subans[3]=num[l];
					ans.push_back(subans);
					k++;l--;
					while(k<l&&num[k]==num[k-1]) k++;
					while(k<l&&num[l]==num[l+1]) l--;
				}
				else if(num[i]+num[j]+num[k]+num[l]>target){
					l--;
				}else k++;
				
				
			}
			while(j<n-1&&num[j+1]==num[j]) j++;
		}
		while(i<n-1&&num[i+1]==num[i]) i++;
	}
	return ans;
}


int main(int argc, char *argv[]) {
	vector<int> a;
	int b[]={1,0,-1,0,-2,2};
	for(int i=0;i<6;i++)
	{
		a.push_back(b[i]);
	}
	vector<vector<int> > c = fourSum(a,0);
	for(int i=0;i<c.size();i++)
	{
		for(int j=0;j<4;j++)
		{
			cout<<c[i][j]<<" ";
		}
		cout<<endl;
	}
}