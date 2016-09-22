package com.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class robTest {

    @Test
    public void testRob() throws Exception {
        int[] num = {1};
        assertEquals(1,new rob().rob(num));
        assertEquals(2,new rob().rob(num));
    }
}