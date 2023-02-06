package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _167_TwoSum_II_InputArrayIsSorted {

    private final Test test = new Test2();

    static class Test2 implements Test {

        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            int init = 0;
            while ((init = numbers[i] + numbers[j]) != target) {
                if (target < init) j--;
                else i++;
            }
            return new int[]{i + 1, j + 1};
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] numbers, int target, int[] expected) {
        int[] actual = test.twoSum(numbers, target);
        Assert.assertTrue(Arrays.equals(expected, actual));
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15},
                        9,
                        new int[]{1, 2}
                ),
                arguments(new int[]{2, 3, 4},
                        6,
                        new int[]{1, 3}
                ),
                arguments(new int[]{-1, 0},
                        -1,
                        new int[]{1, 2}
                ),
                arguments(new int[]{1, 2, 3, 4, 4, 9, 56, 90},
                        8,
                        new int[]{4, 5}
                )
        );
    }

    interface Test {
        int[] twoSum(int[] numbers, int target);
    }

    static class Test1 implements Test {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] + numbers[j] == target) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
            return new int[]{};
        }
    }
}
