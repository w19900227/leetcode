package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _121_best_time_to_buy_and_sell_stockTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public int maxProfit(int[] prices) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#HashTable()
     * @see Topic#DivideAndConquer()
     * @see Topic#Sorting()
     * @see Topic#Counting()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int expected) {
        int actual = leetCode.maxProfit(nums);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int maxProfit(int[] prices) {
            return 0;
        }
    }

    public interface LeetCode {
        int maxProfit(int[] prices);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{7, 1, 5, 3, 6, 4},
                        5
                ),
                arguments(new int[]{7, 6, 4, 3, 1},
                        0
                )
        );
    }
}