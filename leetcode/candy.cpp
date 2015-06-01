#include <iostream>
#include <vector>
using namespace std;

int candy(vector<int> &ratings) {
	int n = ratings.size();
	vector<int> candy(n);
	int curCandy = 1;
	for(int i=0;i<n-1;i++)
	{
		if (ratings[i+1]>ratings[i]) {
			candy[i] = curCandy++;
		} else {
			candy[i] = curCandy;
			curCandy = 1;
		}
	}
	if(ratings[n-1]>ratings[n-2]) candy[n-1]=curCandy;
	else candy[n-1]=1;
	curCandy = 1;
	for(int i=n-1;i>0;i--)
	{
		if (ratings[i-1]>ratings[i]) {
			candy[i] = max(candy[i],curCandy);
			curCandy++;
		} else {
			candy[i] = max(candy[i],curCandy);
			curCandy = 1;
		}
	}
	
	if(ratings[0]>ratings[1]) candy[0]=curCandy;
		else candy[0]=1;
		
	for(int i=0;i<n;i++) cout<<candy[i]<<endl;
		
	int total = 0;
	for(int i=0;i<n;i++)
	{
		total += candy[i];
	}
	return total;
}

int main(int argc, char *argv[]) {
	vector<int> a(2);
	int b[] = {2,1};
	for(int i=0;i<2;i++) a[i]=b[i];
	cout<<candy(a)<<endl;
}