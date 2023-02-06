package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DynamicProgrammingFactorial {

    @Test
    public void test1() {
        assertNumTrees(2, 2);
    }

    @Test
    public void test2() {
        assertNumTrees(3, 6);
    }

    @Test
    public void test3() {
        assertNumTrees(100, 6);
    }

    @Test
    public void test4() {
        assertNumTrees(10000, 6);
    }

    @Test
    public void test5() {
        assertNumTrees(1000000, 6);
    }

    private void assertNumTrees(int n, int expected) {
        long actual = factorial(n);
        Assert.assertEquals(expected, actual);
    }

    public long factorial(long n) {
        Map<Long, Long> factorial = new HashMap<>();
        factorial.put(0L, 1L);
        for (long i = 1; i <= n; i++) {
            factorial.put(i, i * factorial.get(i - 1));
        }
        return factorial.get(n);
    }
}