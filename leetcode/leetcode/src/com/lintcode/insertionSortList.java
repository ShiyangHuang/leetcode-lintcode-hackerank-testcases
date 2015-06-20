package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/17.
 */
public class insertionSortList {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode p = vHead;
        ListNode q = p.next;
        while (p != null) {
            p = p.next;
            if (p.val < q.val) {
                q = p;
            }
        }
        return vHead.next;
    }
}
