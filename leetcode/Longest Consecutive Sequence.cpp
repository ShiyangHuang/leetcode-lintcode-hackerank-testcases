#include<iostream>
#include<vector>
#include <set>

using namespace std;
int longestConsecutive(vector<int> &num) {
             
    int ans = 0,answer = 0; 
    set<int> flag; 
    set<int>::iterator iter; 
    flag.clear(); 
    for(int i = 0 ; i < num.size() ; i++) 
        flag.insert(num[i]); 
    for(int i = 0 ; i < num.size(); i++){
        if((iter = flag.find(num[i])) != flag.end())
        {
            int ans = 1;
            flag.erase(num[i]);
            set<int>::iterator iter;
            int n = num[i]+1;
            while((iter = flag.find(n)) != flag.end())
            { 
               flag.erase(iter); 
               ans ++;
               n++;
            } 
            n = num[i]-1;
            while((iter = flag.find(n)) != flag.end())
            { 
                 flag.erase(iter); 
                 ans ++;
                 n--; 
            } 
        }
        if(answer<ans) answer = ans;
    }            
    return answer; 
} 


main()
{
    int a[] = {1,2,3,4,5,6};
    cout<<longestConsecutive(a);
    system("pause");
    
}    
