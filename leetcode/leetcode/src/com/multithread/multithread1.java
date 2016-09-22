package com.multithread;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/4/18.
 */
public class multithread1 {
    static int x = 0;

    public static void addOne() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            x++;
            System.out.println(x);
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(runnable));
        }

        for (int i = 0; i < 5; i++) {
            threads.get(i).start();
        }
    }
}
