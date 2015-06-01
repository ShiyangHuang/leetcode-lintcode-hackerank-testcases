#include <iostream>
#include <vector>
using namespace std;

int threeSumClosest(vector<int> &num, int target) {
    sort(num.begin(),num.end());
	int n=num.size();
	int min = MAX_INT;
	for(int i=0;i<n;i++)
	{
		int j=i+1,k=n-1;
		while (j<k)
		{
			if (abs(num[i]+num[j]+num[k]-target)<min)
			{
				min=abs(num[i]+num[j]+num[k]-target);
			}if (num[i]+num[j]+num[k]>target) k--;
			else j++;
		}
	}
	return min;
}

int main(int argc, char *argv[]) {
	
}