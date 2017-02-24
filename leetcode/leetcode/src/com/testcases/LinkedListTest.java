package com.testcases;

import java.util.LinkedList;

/**
 * Created by shiyanghuang on 16/10/20.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.offerFirst(3);
        list.offerFirst(4);
        list.offerFirst(5);
        list.offerFirst(6);
        list.offerFirst(7);
        list.offerFirst(8);
        list.offerLast(2);
        list.offerLast(1);

        print(list);

        System.out.println("peek: " + list.peek()); // peek the first element
        System.out.println("peekFirst: " + list.peekFirst());
        System.out.println("peekLast: " + list.peekLast());

        print("Origin: ", list);
        list.poll(); // poll at the first element
        print("poll: ", list);
        list.pollFirst();
        print("pollFirst: ", list);
        list.pollLast();
        print("pollLast: ", list);

        list.remove();
        print("remove: ", list);
        list.removeFirst();
        print("removeFirst: ", list);
        list.removeLast();
        print("removeLast: ", list);

        list.add(9); //add at the end
        print("add: ", list);
        list.addFirst(10);
        print("addFirst: ", list);
        list.addLast(11);
        print("addLast: ", list);
    }

    public static void print(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void print(String str, LinkedList<Integer> list) {
        System.out.print(str);
        print(list);
    }
}
