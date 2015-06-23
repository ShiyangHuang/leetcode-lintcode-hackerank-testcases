package com.buptaaa.term1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/22.
 */
public class MergeRingStones {
    public int MergeRingStones(int[] stones) {
        List<Integer> st = new ArrayList<Integer>();
        for (int i = 0; i < stones.length; i++) {
            st.add(stones[i]);
        }
        int total = 0;
        while (st.size() > 1) {
            int max = 0;
            int position = 0;
            for (int i = 0; i < st.size(); i++) {
                if (st.get(i) + st.get((i + 1) % st.size()) > max) {
                    position = i;
                    max = st.get(i) + st.get((i + 1) % st.size());
                }
            }
            if (position == st.size() - 1) {
                total += st.get(0) + st.get(position);
                st.set(0, st.get(0) + st.get(position));
            }
            else {
                total += st.get(position) + st.get(position + 1);
                st.set(position, st.get(position) + st.get(position + 1));
            }
            st.remove((position + 1) == st.size() ? position : position + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {4,4,5,9};
        System.out.print(new MergeRingStones().MergeRingStones(a));
    }
}
