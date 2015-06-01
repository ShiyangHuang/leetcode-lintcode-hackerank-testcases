#include <iostream>
#include <map>
using namespace std;
int main(int argc, char *argv[]) {
	map<int, int> m;
	map<int, int>::iterator it;
	m[0] = 1;
	m[4] = 2;
	m[3] = 4;
	it = m.find(1);
	if(it != m.end()) {
		cout<<it->first<<endl;
	} else {
		cout<<"Not found"<<endl;
	}
	m.erase(3);
	cout<<m.size()<<endl;
	for (it = m.begin(); it != m.end(); it++ ) {
		cout<<it->first<<" "<<it->second<<endl;	}
	
}