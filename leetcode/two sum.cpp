#include<iostream>
#include<map>
#include<vector>

using namespace std;

    vector<int> twoSum(vector<int> &numbers, int target) {
        vector<int> ans;
        int n = numbers.size();
        map<int,int> hashmap;
        for(int i=0;i<n;i++)
        {
            if(hashmap[target-numbers[i]]!=0)
            {
                //cout<<numbers[i]<<" "<<i+1<<endl;
                ans.push_back(min(hashmap[target-numbers[i]],i+1));
                ans.push_back(max(hashmap[target-numbers[i]],i+1));
                break;
            } else {
                hashmap[numbers[i]] = i+1;
            }    
        }
        return ans;
    }
    
main()
{
    vector<int> b;
    int a[] = {1,2,3,4,5};
    for(int i=0;i<5;i++) b.push_back(a[i]);
    vector<int> ans = twoSum(b,8);
    cout<<ans[0]<<" "<<ans[1]<<endl;
    system("pause");
    
 }     
