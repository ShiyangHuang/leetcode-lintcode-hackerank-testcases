#include<iostream>
using namespace std;

 //Definition for singly-linked list. * 
 struct ListNode {
     int val;     
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };


ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode *ans = new ListNode(0),*a = ans,*ll1 = l1,*ll2 = l2;
    int flag = 0;
    while(ll1 != NULL && ll2 != NULL)
    {
        a->val = ll1->val + ll2-> val + flag;
        if(a->val >9)
        {
            a->val -= 10;
            flag = 1;
        }
        else flag = 0;
        if(ll1->next != NULL || ll2->next != NULL)
        {
            a->next = new ListNode(0);
            a = a->next;
        }    
        ll1 = ll1->next;
        ll2 = ll2->next;
    }
    while(ll1 != NULL)
    {
        a->val = ll1->val + flag;
        if(a->val >9)
        {
            a->val -= 10;
            flag = 1;
        }
        else flag = 0;
        if(ll1->next != NULL)
        {
            a->next = new ListNode(0);
            a = a->next;
        }    
        ll1 = ll1->next;
    }
    while(ll2 != NULL)
    {
        a->val = ll2->val + flag;
        if(a->val >9)
        {
            a->val -= 10;
            flag = 1;
        }
        else flag = 0;
        if(ll2->next != NULL)
        {
            a->next = new ListNode(0);
            a = a->next;
        }    
        ll2 = ll2->next;
    }
    if(flag == 1)
    {
        a->next = new ListNode(0);
        a = a->next;
        a->val = 1;
    }    
    return ans;       
}

main()
{
    ListNode *x1 = new ListNode(3);
    ListNode *x2 = new ListNode(0);
    cout<<addTwoNumbers(x1,x2)->val;
    system("pause");
}    
