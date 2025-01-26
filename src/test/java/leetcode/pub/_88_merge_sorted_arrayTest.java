package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _88_merge_sorted_arrayTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
        }
    }

    /**
     * https://leetcode.com/problems/merge-sorted-array
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#TwoPointers()
     * @see Topic#Sorting()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        leetCode.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(expected, nums1);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int m1 = m - 1;
            int n1 = n - 1;
            int k = m + n - 1;
            while (n1 >= 0) {
                if (m1 >= 0 && nums1[m1] > nums2[n1]) {
                    nums1[k--] = nums1[m1--];
                } else {
                    nums1[k--] = nums2[n1--];
                }
            }
        }
    }

    public interface LeetCode {
        void merge(int[] nums1, int m, int[] nums2, int n);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 0, 0, 0},
                        3,
                        new int[]{2, 5, 6},
                        3,
                        new int[]{1, 2, 2, 3, 5, 6}
                ),
                arguments(new int[]{1},
                        1,
                        new int[]{},
                        0,
                        new int[]{1}
                ),
                arguments(new int[]{0},
                        0,
                        new int[]{1},
                        1,
                        new int[]{1}
                ),
                arguments(new int[]{2, 0},
                        1,
                        new int[]{1},
                        1,
                        new int[]{1, 2}
                )
        );
    }
}