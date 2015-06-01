#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0;i<n;i++) {
        cin>>a[i];
    }
    sort(a.begin(),a.end());
    int current = a[0];
    cout<<n<<endl;
    for(int i=1;i<n;i++) {
        if(a[i] != current) {
            cout<<n-i<<endl;
            current = a[i];
        }
    }
    return 0;
}

