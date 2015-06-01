#include<iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
ListNode *reverseBetween(ListNode *head, int m, int n) {
    ListNode *veryhead = new ListNode(0);
    veryhead->next = head;
    ListNode *start = veryhead;
    while(m>1)
    {
        start=start->next;
        m--;
    }    
    ListNode *end = veryhead;
    while(n>0)
    {
        end=end->next;
        n--;
    }
    while(start->next!=end)
    {
        ListNode *temp=start->next;
        start->next=start->next->next;
        temp->next=end->next;
        end->next=temp;
    }
    return veryhead->next;
}
main()
{
}    
