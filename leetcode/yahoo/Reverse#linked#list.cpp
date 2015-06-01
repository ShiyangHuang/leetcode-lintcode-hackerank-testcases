#include<iostream>
using namespace std;
struct LinkNode{
    int val;
    LinkNode *next;
    LinkNode(int x) : val(x) ,next(NULL){}
};

LinkNode *ReverseLinkList(LinkNode *node)
{
    LinkNode *head=new LinkNode(0);
    LinkNode *newhead=new LinkNode(0);
    head->next=node;
    LinkNode *p,*q,*r;
    p=head;
    q=head->next;
    while(head->next!=NULL)
    {
        r=newhead->next;
        newhead->next=q;
        p=q->next;
        q->next=r;
        head->next=p;
        p=head;
        q=head->next;
    }    
    return newhead->next;
}

main()
{
    LinkNode *head=new LinkNode(0);
    LinkNode *p=head;
    for(int i=1;i<10;i++)
    {
        LinkNode *t=new LinkNode(i);    
        p->next=t;
        p=t;
    }
    p=ReverseLinkList(head);
    while(p!=NULL)
    {
        cout<<p->val<<" ";
        p=p->next;
    }
    system("pause");
}        
