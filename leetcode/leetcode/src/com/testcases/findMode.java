package com.testcases;


import java.util.*;

/**
 * Created by shiyanghuang on 17/2/1.
 */
public class findMode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        dfs(root, map);
        Iterator it = map.entrySet().iterator();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int max = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((Integer) entry.getValue() > max) {
                max = (Integer) entry.getValue();
                ans = new ArrayList<Integer>();
                ans.add((Integer) entry.getKey());
            } else if ((Integer) entry.getValue() == max) {
                ans.add((Integer) entry.getKey());
            }
        }
        return toArray(ans);
    }

    private void dfs(TreeNode node, HashMap<Integer, Integer> map){
        if (node == null) return;
        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }
        dfs(node.left, map);
        dfs(node.right, map);
    }

    public int[] toArray(ArrayList<Integer> collection) {

        Object[] boxedArray = collection.toArray();
        int len = boxedArray.length;
        int[] array = new int[len];
        for(int i = 0; i < len; ++i) {
            array[i] = ((Integer) (boxedArray[i])).intValue();
        }
        return array;
    }
}
