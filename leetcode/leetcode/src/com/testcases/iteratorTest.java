package com.testcases;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shiyanghuang on 16/9/23.
 */
public class iteratorTest {
    public static void main(String[] args) {
        Map map;
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("asdf","asdfg\tasdfgh\tasdfghj");
        hmap.put("zxcv","zxcvb\tasd\tas");
        hmap.put("qwer","qwert\tqwe\tqw");
        map = hmap;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String obj = it.next().toString();
            System.out.println(obj);
            System.out.println(obj.split("=")[1].split("\t")[2]);
            //System.out.println(obj.toString());
        }

    }
}
