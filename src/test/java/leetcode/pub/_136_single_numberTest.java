package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _136_single_numberTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public int singleNumber(int[] nums) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/single-number
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#BitManipulation()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int expected) {
        int actual = leetCode.singleNumber(nums);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int singleNumber(int[] nums) {
            return 0;
        }
    }

    public interface LeetCode {
        int singleNumber(int[] nums);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{2, 2, 1},
                        1
                ),
                arguments(new int[]{4, 1, 2, 1, 2},
                        4
                ),
                arguments(new int[]{1},
                        1
                )
        );
    }
}