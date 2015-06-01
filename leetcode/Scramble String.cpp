#include<iostream>
#include<vector>
using namespace std;
 
bool isScramble(string s1, string s2) {
    int len = s1.length();
    if(len!=s2.length()) return false;
    if(len==0) return true;
    
    vector<vector<vector<bool> > > flag(len, vector<vector<bool> >(len, vector<bool>(len)));
    for (int i=0;i<len;i++) {
        for (int j=0;j<len;j++) {
            flag[0][i][j] = (s1[i] == s2[i]);
        }
    }        
    
    for (int k=2;k<=len;k++) {
        for (int i=len-k;i>=0;i--) {
            for (int j=len-k;j>=0;j--) {
                bool r = false;
                for (int m=1;m<k && !r;m++) {
                    r = (flag[m-1][i][j] && flag[k-m-1][i+m][j+m]) || (flag[m-1][i][j+k-m] && flag[k-m-1][i+m][j]);
                }
                flag[k-1][i][j] = r;
            }
        }
    }
    return flag[len-1][0][0];                    
}
