#include<iostream>
using namespace std;

ListNode *partition(ListNode *head, int x) {
    ListNode *f = new ListNode(0);
    f->next = head;
    ListNode *p=f,*q,*r,*s;
    while(p->next&&p->next->val<x) p=p->next;
    q=p->next;r=p->next;
    while(r&&r->next)
    {
        if(r->next->val<x)
        {
            s=r->next->next;
            p->next=r->next;
            p=p->next;
            p->next=q;
            q->next=s;
        }
        else
        {
            r=r->next;
        }
    }        
    return f->next; 
}
