#include<iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* mergeLists(ListNode *a, ListNode *b) //�ϲ������Ѿ����������
	{
		if (a == NULL) return b ;
		if (b == NULL) return a ;
		ListNode *ret = NULL ;
		ListNode *tail = NULL ;
		
		ret = new ListNode(-1) ;
		tail = ret ;
		
		while (a && b)
			if (a->val < b->val)
			{
				tail->next = a ;
				tail = tail->next ;
				a = a->next ;
			}
			else
			{
				tail->next = b ;
				tail = tail->next ;
				b = b->next ;
			}
		if (a)
			tail->next = a ;
		if (b)
			tail->next = b ;

		ListNode *del = ret ;
		ret = ret->next ;
		delete del ;

		return ret ;
	}

	ListNode *getMid(ListNode *head) //�õ��м�ڵ�
	{ 
		if (!head) return NULL ;
		if (!head->next) return head ;

		ListNode *slow = head ;
		ListNode *fast = head->next ;

		while (fast && fast->next)
		{
			slow = slow->next ;
			fast = fast->next->next ;
		}
		return slow ;
	}

	ListNode *sortList(ListNode *head) { //�ϲ�����

		if (!head) return NULL ;
		if (!head->next) return head ;

		ListNode *mid = getMid(head) ;
		ListNode *nextPart = NULL ;
		if (mid)
		{
			nextPart = mid->next ;
			mid->next = NULL ;
		}

		return mergeLists(
			 sortList(head) ,
			 sortList(nextPart) 
			) ;
	}
