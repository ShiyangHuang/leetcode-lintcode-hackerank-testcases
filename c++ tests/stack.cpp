#include <iostream>
#include <stack>
using namespace std;
int main(int argc, char *argv[]) {
	stack<int> stk;
	stk.push(1);
	stk.push(2);
	cout<<stk.size()<<endl;
	cout<<stk.top()<<endl;
	stk.pop();
	cout<<stk.size()<<endl;
	cout<<stk.empty()<<endl;
}