/**
 * Definition for singly-linked list.
 * 
 */
#include<iostream>
using namespace std;

struct ListNode {
       int val;
       ListNode *next;
       ListNode(int x) : val(x), next(NULL) {}
   };  
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int nA=0,nB=0;
        ListNode *tempA = headA;
        while(tempA!=NULL)
        {
             nA++;
             tempA=tempA->next;   
        }    
        ListNode *tempB = headB;
        while(tempB!=NULL)
        {
             nB++;
             tempB=tempB->next;   
        }
        if(nA>nB)
        {
            while(nA>nB)
            {
                headA=headA->next;
                nA--;
            }
        }
        else if(nA<nB)
        {
            while(nA<nB)
            {
                headB=headB->next;
                nB--;
            }
        }
        ListNode *ans = headA;
        if(ans==NULL) return ans;
        
        do
        {
            if(headA->val!=headB->val)
            {
                ans=headA->next;
            }
            headA=headA->next;
            headB=headB->next;
        }while(headB!=NULL);
        return ans;               
    }
    
    main()
    {
        

