#include<iostream>
using namespace std;

  //Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      //ListNode(int x) : val(x), next(NULL) {}
  };
 
bool *detectCycle(ListNode *head) {
      if(head == NULL) return true;
      ListNode *r1 = head, *r2 = head;
      while(r2!=NULL && r2->next != NULL)
      {
          r1 = r1->next;
          r2 = r2->next->next; 
          if(r1 == r2) break;
      }
      if(r2 == NULL || r2->next == NULL) return false;
      return true;
} 


main()
{
    ListNode *h,*head;
    head = h;
    for(int i=0;i<10;i++)
    {
        h->val = i;
        ListNode *x;
        h->next = x;
        h = x;
    }
    cout<<detectCycle(head);
    system("pause");
}
    
