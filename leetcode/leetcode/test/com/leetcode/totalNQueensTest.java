package com.leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class totalNQueensTest {
    private totalNQueens nq = new totalNQueens();
    @Test
    public void testTotalNQueens() throws Exception {
        assertEquals(92, nq.totalNQueens(8));
    }
}