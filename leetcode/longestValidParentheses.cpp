#include <iostream>
#include <vector>
#include <stack>
using namespace std;

    int longestValidParentheses(string s) {
        stack<int> stk;
        vector<bool> flag(s.length(), false);
        for(int i = 0; i < s.length(); ++i) {
            if(s[i] == '(') {
                stk.push(i);
            } else if (!stk.empty()) {
                flag[i] = true;
                flag[stk.top()] = true;
                stk.pop();
            }
        }

        int ans = 0;
        int subans = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(flag[i]) {
                subans++;
            } else {
                ans = ans>subans?ans:subans;
                subans = 0;
            }
        }
		

        return ans;
    }

int main(int argc, char *argv[]) {
	cout<<longestValidParentheses("()")<<endl;
}