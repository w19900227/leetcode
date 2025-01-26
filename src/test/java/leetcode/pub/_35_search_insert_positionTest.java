package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _35_search_insert_positionTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public int searchInsert(int[] nums, int target) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/search-insert-position
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#BinarySearch()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int target, int expected) {
        int actual = leetCode.searchInsert(nums, target);
        Assert.assertEquals(expected, actual);
    }

    // O(n)
    public static class Solution1 implements LeetCode {
        @Override
        public int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target || nums[i] > target) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    // O(log n)
    public static class Solution2 implements LeetCode {
        @Override
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) end = mid - 1;
                else start = mid + 1;
            }
            return start;
        }
    }

    public interface LeetCode {
        int searchInsert(int[] nums, int target);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1, 3, 5, 6},
                        5,
                        2
                ),
                arguments(new int[]{1, 3, 5, 6},
                        2,
                        1
                ),
                arguments(new int[]{1, 3, 5, 7},
                        6,
                        3
                ),
                arguments(new int[]{1, 3, 5, 6},
                        7,
                        4
                ),
                arguments(new int[]{1, 3, 5, 6},
                        0,
                        0
                )
        );
    }
}