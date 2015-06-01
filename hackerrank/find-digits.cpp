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
    while(n--) {
        int a;
        cin>>a;
        int b = a;
        int count = 0;
        while(b>0) {
            if(b%10!=0 && a%(b%10) == 0) {
                count++;
               
            }
        }
        cout<<count<<endl;
    }
    system("pause");
    return 0;
}

