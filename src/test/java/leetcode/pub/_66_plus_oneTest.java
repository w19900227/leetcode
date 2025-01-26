package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _66_plus_oneTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public int[] plusOne(int[] digits) {
            return new int[]{};
        }
    }

    /**
     * https://leetcode.com/problems/plus-one
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#Math()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] digits, int[] expected) {
        int[] actual = leetCode.plusOne(digits);
        Assert.assertArrayEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

    public interface LeetCode {
        int[] plusOne(int[] digits);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1, 2, 3},
                        new int[]{1, 2, 4}
                ),
                arguments(new int[]{4, 3, 2, 1},
                        new int[]{4, 3, 2, 2}
                ),
                arguments(new int[]{4, 3, 2, 9},
                        new int[]{4, 3, 3, 0}
                ),
                arguments(new int[]{9},
                        new int[]{1, 0}
                ),
                arguments(new int[]{9, 9},
                        new int[]{1, 0, 0}
                )
        );
    }
}