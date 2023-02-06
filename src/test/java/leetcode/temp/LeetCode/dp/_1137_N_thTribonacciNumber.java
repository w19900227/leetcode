package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _1137_N_thTribonacciNumber {

    @Test
    public void test1() {
        int input = 0;
        assertTribonacci(input, 0);
    }

    @Test
    public void test2() {
        int input = 1;
        assertTribonacci(input, 1);
    }

    @Test
    public void test3() {
        int input = 4;
        assertTribonacci(input, 4);
    }

    @Test
    public void test4() {
        int input = 25;
        assertTribonacci(input, 1389537);
    }

    private void assertTribonacci(int n, int expected) {
        long actual = tribonacci(n);
        Assert.assertEquals(expected, actual);
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 3] + result[i - 2] + result[i - 1];
        }
        return result[n];
    }
}