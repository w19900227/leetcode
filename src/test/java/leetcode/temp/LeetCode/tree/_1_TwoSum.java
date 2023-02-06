package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _1_TwoSum {

    private static final Test test = new Test1();

    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] intArray, int target, int[] expected) {
        int[] actual = test.twoSum(intArray, target);
        Assert.assertTrue(Arrays.equals(expected, actual));
    }

    interface Test {
        int[] twoSum(int[] nums, int target);
    }

    static class Test1 implements Test {
        public int[] twoSum(int[] nums, int target) {
            int[] result = {};
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result = new int[]{i, j};
                        return result;
                    }
                }
            }
            return result;
        }
    }

    static class Test2 implements Test {
        public int[] twoSum(int[] nums, int target) {
            return helper(nums, target, 0, 1);
        }

        private int[] helper(int[] nums, int target, int index1, int index2) {
            int numLength = nums.length - 1;
            if (numLength < index1 || numLength < index2) return new int[]{};
            if ((nums[index1] + nums[index2]) == target) return new int[]{index1, index2};
            if (numLength == index2) index2 = ++index1;
            return helper(nums, target, index1, ++index2);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1}),
                arguments(new int[]{2, 5, 5, 11}, 10, new int[]{1, 2})
        );
    }
}