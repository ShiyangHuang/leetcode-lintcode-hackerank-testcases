#include <iostream>
#include <map>
using namespace std;

bool isIsomorphic(string s, string t) {
        map<char, char> m1, m2;
        for(int i = 0; i < s.length() ; i ++) {
				cout<<i<<endl;
            if(m1.find(s[i])!=m1.end()) {
					cout<<"m1 "<<s[i]<<" "<<m1[s[i]]<<" "<<t[i]<<endl;
                if(m1[s[i]] != t[i]) return false;
            }
            if(m2.find(t[i])!=m2.end()) {
					cout<<"m2"<<endl;
                if(m2[t[i]] != s[i]) return false;
            }
            m1[s[i]] = t[i];
            m2[t[i]] = s[i];
        }
        return true;
    }

int main(int argc, char *argv[]) {
	cout<<isIsomorphic("aa","bb");
}