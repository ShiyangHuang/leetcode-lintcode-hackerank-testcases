#include<iosteam>
#include<vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


ListNode *mergeKLists(vector<ListNode *> &lists) {
     int k=0,listn=lists.size();
     
     cout<<listn<<endl;
     return lists[0];
}

main()
{
    
}    
