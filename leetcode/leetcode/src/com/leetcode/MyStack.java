package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class MyStack {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (queue.size() > 1) {
            queue2.add(queue.remove());
        }
        int res = queue.remove();
        while (!queue2.isEmpty()) {
            queue.add(queue2.remove());
        }
    }

    // Get the top element.
    public int top() {
        while (queue.size() > 1) {
            queue2.add(queue.remove());
        }
        int res = queue.remove();
        while (!queue2.isEmpty()) {
            queue.add(queue2.remove());
        }
        queue.add(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}
