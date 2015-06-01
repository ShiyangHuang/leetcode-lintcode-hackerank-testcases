#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int largestRectangleArea(vector<char> &h) {
	vector<int> height(h.size());
	for (int i=0;i<h.size();i++) {
		height[i] = h[i]-'0';
	}
	height.push_back(0);
	int maxArea = 0;
	int i = 0;
	stack<int> stk;
	while (i<height.size()) {
		if (stk.empty()||height[i]>=height[stk.top()]) {
			stk.push(i++);
		} else {
			int t = stk.top();
			stk.pop();
			maxArea = max(maxArea, height[t]*(stk.empty()?i:i-stk.top()-1));
		}
	}
	return maxArea;
}

int maximalRectangle(vector<vector<char> > &matrix) {
	if(matrix.size()==0) return 0;
	
	for (int j=0;j<matrix[0].size();j++) {
		for (int i=1;i<matrix.size();i++) {
			if(matrix[i][j]!='0')
				matrix[i][j]+=matrix[i-1][j]-'0';
		}
	}
	for (int i=0;i<matrix.size();i++) {
			for (int j=0;j<matrix[0].size();j++) {
				cout<<matrix[i][j]<<" ";
			}
			cout<<endl;
		}
		
	int ans = 0;
	for (int i=0;i<matrix.size();i++) {
		int area = largestRectangleArea(matrix[i]);
		if (ans<area) {
			ans = area;
			//cout<<i<<" ans = "<<ans<<endl;
		}
	}
	return ans;
}


int main(int argc, char *argv[]) {
	vector<vector<char> > a;
	vector<char> b;
	b.push_back('1');
	b.push_back('1');
	b.push_back('0');
	b.push_back('1');
	a.push_back(b);
	a.push_back(b);
	b[2] = '1';
	a.push_back(b);
	//cout<<largestRectangleArea(b)<<endl;
	cout<<maximalRectangle(a)<<endl;
}