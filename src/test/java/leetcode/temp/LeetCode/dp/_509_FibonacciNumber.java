package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _509_FibonacciNumber {

    @Test
    public void test1() {
        int input = 2;
        assertFibByCalculate(input, 1);
    }

    @Test
    public void test2() {
        int input = 3;
        assertFibByCalculate(input, 2);
    }

    @Test
    public void test3() {
        int input = 4;
        assertFibByCalculate(input, 3);
    }

    @Test
    public void test4() {
        int input = 0;
        assertFibByCalculate(input, 0);
    }

    private void assertFibByCalculate(int n, int expected) {
        int actual = fib(n);
        Assert.assertEquals(expected, actual);
    }

//    public int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fib(n - 2) + fib(n - 1);
//    }

    public int fib(int n) {
        if (n == 0) return 0;
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[n];
    }
}