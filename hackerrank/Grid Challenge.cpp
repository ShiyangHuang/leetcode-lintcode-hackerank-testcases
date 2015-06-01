#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
	freopen("in","r",stdin);
	freopen("out","w",stdout);
    int t;
    cin >> t;
t = 52;
    while (t--) {
        int n;
        cin >> n;
		cout<<n;
        bool flag = true;
        if(n != 1) {
            vector<vector<char> > a(n,vector<char>(n));
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                  cin >> a[i][j];
                   // cout<<a[i][j];
                }
                sort(a[i].begin(),a[i].end());
            }
            for(int i = 1; i < n; i ++) {
                for(int j = 1; j < n; j ++) {
                    if(a[i][j]<a[i-1][j] || a[i][j] < a[i][j-1]) {
                        flag = false;
                    }
                }
            }
            if (a[0][1] < a[0][0] || a[1][0] < a[0][0]) flag = false;
        }

        if (flag) {
            cout<<"YES"<<endl;
        } else {
            cout<<"NO"<<endl;
        }
    }
    return 0;
}
