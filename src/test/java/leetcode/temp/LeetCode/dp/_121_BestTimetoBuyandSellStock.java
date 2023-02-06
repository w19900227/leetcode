package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _121_BestTimetoBuyandSellStock {

    @Test
    public void test1() {
        int[] price = new int[]{7, 1, 5, 3, 6, 4};
        assertMaxProfit(price, 5);
    }

    private void assertMaxProfit(int[] price, int expected) {
        long actual = maxProfit(price);
        Assert.assertEquals(expected, actual);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min < prices[i]) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}