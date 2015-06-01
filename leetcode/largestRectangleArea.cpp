#include <iostream>
#include <vector>
#include <stack>
using namespace std;
    int Max(int a, int b){return a > b ? a : b;}
    int largestRectangleArea(vector<int> &height) {
    	height.push_back(0);
        stack<int> stk;
        int i = 0;
        int maxArea = 0;
        while(i < height.size()){
            if(stk.empty() || height[stk.top()] <= height[i]){
                stk.push(i++);
            }else {
                int t = stk.top();
				stk.pop();
                maxArea = Max(maxArea, height[t] * (stk.empty() ? i : i - stk.top() - 1));
            }
        }
        return maxArea;
    }

int main(int argc, char *argv[]) {
	int a[] = {2,1,5,6,2,3};
	vector<int> b(6);
	for(int i=0;i<6;i++) b[i]=a[i];
	cout<<largestRectangleArea(b)<<endl;

}