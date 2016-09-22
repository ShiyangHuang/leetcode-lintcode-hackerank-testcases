package com.testcases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 16/1/5.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            arrayList.add(i + "");
        }
        for (int i = 0; i < 15; i++) {
            arrayList.add(i + "");
        }

        removeDuplicate(arrayList);
        String[] array = arrayList.toArray(new String[arrayList.size()]);
        for (String str : array) {
            System.out.println(str);
        }

    }

    public static void removeDuplicate(List<String> array) {
        int i = 0;
        boolean f = true;
        while (i < array.size()) {
            int j = 0;
            while (j < array.size()) {
                if (i != j && array.get(i).startsWith(array.get(j))) {
                    // array.set(i, "remove");
                    array.remove(i);
                    f = false;
                    break;
                }
                j++;
            }
            if (f) {
                i++;
            } else {
                f = true;
            }
        }
    }
}
