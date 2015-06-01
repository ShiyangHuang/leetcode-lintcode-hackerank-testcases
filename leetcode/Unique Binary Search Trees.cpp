#include<iostream>
#include<vector>
using namespace std;
    int numTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        // This is Catalan  v[i] = v[1]*v[i-1] + v[2]*v[i-2] + ... + v[i-1]*v[1]
        vector<int> v(n+1, 0);
        v[0] = 1;
        v[1] = 1;
        v[2] = 2;
        if(n<=2)
           return v[n];
           
        for(int i=3; i<=n; i++)
            for(int j=1; j<=i; j++)
                v[i] += v[j-1]*v[i-j];
        return v[n];
    }
    
main()
{
    cout<<numTrees(3)<<endl;
    system("pause");
}    
