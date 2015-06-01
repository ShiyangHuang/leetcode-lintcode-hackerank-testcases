#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    vector<long long> fibo;
    fibo.push_back(0);
    fibo.push_back(1);
    fibo.push_back(2);
    fibo.push_back(3);
    while(fibo[fibo.size()-1]<(1<<31-1)) {
        fibo.push_back(fibo[fibo.size()-1]+fibo[fibo.size()-2]);
    }

    int n;
    cin>>n;
    for(int i=0;i<n;i++) {
        long long input;
        cin>>input;
        for(int i=0;i<fibo.size();i++){
            if(input == fibo[i]) {
                cout<<"IsFibo"<<endl;
                break;
            }
            if(input<fibo[i]) {
                cout<<"IsNotFibo"<<endl;
                break;
            }
        }
    }
    system("pause");
    return 0;
}
