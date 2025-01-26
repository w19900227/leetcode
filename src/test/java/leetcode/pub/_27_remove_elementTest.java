package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _27_remove_elementTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public int removeElement(int[] nums, int val) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/remove-element
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#TwoPointers()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int val, int expected) {
        int actual = leetCode.removeElement(nums, val);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int removeElement(int[] nums, int val) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            return index;
        }
    }

    public interface LeetCode {
        int removeElement(int[] nums, int val);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{3, 2, 2, 3},
                        3,
                        2
                ),
                arguments(new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                        2,
                        5
                ),
                arguments(new int[]{3, 3},
                        3,
                        0
                )
        );
    }
}