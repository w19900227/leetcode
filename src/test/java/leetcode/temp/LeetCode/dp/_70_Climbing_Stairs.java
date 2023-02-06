package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _70_Climbing_Stairs {

    @Test
    public void test1() {
        assertClimbStairs(2, 2);
    }

    @Test
    public void test2() {
        assertClimbStairs(3, 3);
    }

    @Test
    public void test3() {
        assertClimbStairs(4, 5);
    }

    @Test
    public void test4() {
        assertClimbStairs(5, 8);
    }

    @Test
    public void test5() {
        assertClimbStairs(7, 21);
    }

    @Test
    public void test6() {
        assertClimbStairs(1, 1);
    }

    @Test
    public void test7() {
        assertClimbStairs(45, 1836311903);
    }

    private void assertClimbStairs(int n, int expected) {
        long actual = climbStairs(n);
        Assert.assertEquals(expected, actual);
    }

    public int climbStairs(int n) {
        int[] list = new int[n + 1];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i <= n; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[n];
    }

    // Here is not good solve function

    // Time Limit Exceeded
//    public int climbStairs(int n) {
//        return helper(n, new int[n + 1]);
//    }
//
//    private int helper(int n, int[] list) {
//        if (n == 0 || n == 1) return 1;
//        return list[n] = helper(n - 1, list) + helper(n - 2, list);
//    }
}