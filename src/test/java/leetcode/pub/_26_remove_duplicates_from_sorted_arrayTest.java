package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _26_remove_duplicates_from_sorted_arrayTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public int removeDuplicates(int[] nums) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#TwoPointers()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int expectedSize) {
        int actual = leetCode.removeDuplicates(nums);
        Assert.assertEquals(expectedSize, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int removeDuplicates(int[] nums) {
            int j = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] != nums[i]) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            return j;
        }
    }

    public interface LeetCode {
        int removeDuplicates(int[] nums);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1, 1, 2},
                        2
                ),
                arguments(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                        5
                )
        );
    }
}