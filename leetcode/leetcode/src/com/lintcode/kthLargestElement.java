package com.lintcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class kthLargestElement {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        Collections.sort(numbers);
        return numbers.get(k - 1);
    }
}
