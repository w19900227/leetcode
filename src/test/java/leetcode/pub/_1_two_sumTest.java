package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _1_two_sumTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public int[] twoSum(int[] nums, int target) {
            return new int[]{};
        }
    }

    /**
     * https://leetcode.com/problems/two-sum
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#HashTable()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, int target, int[] expected) {
        int[] actual = leetCode.twoSum(nums, target);
        Assert.assertArrayEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }
    }

    public static class Solution2 implements LeetCode {
        @Override
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int size = nums.length;

            for (int i = 0; i < size; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < size; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[]{i, map.get(complement)};
                }
            }
            return new int[]{};
        }
    }

    public interface LeetCode {
        int[] twoSum(int[] nums, int target);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{3, 3},
                        6,
                        new int[]{0, 1}
                ),
                arguments(new int[]{3, 2, 4},
                        6,
                        new int[]{1, 2}
                ),
                arguments(new int[]{2, 7, 11, 15},
                        9,
                        new int[]{0, 1}
                ),
                arguments(new int[]{2, 5, 5, 11},
                        10,
                        new int[]{1, 2}
                )
        );
    }
}