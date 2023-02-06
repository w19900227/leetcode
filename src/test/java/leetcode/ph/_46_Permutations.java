package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _46_Permutations {

    private static final LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/permutations/
     *
     * @see Difficulty#Medium()
     * @see Topic#Array()
     * @see Topic#Backtracking()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> actual = leetCode.permute(nums);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            backtrack(list, new ArrayList<>(), nums);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
            if (nums.length == tempList.size()) {
                list.add(new ArrayList<>(tempList));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (tempList.contains(nums[i])) continue;
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public interface LeetCode {
        List<List<Integer>> permute(int[] nums);
    }


    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{1},
                        Arrays.asList(
                                Arrays.asList(1)
                        )
                ),
                arguments(new int[]{0, 1},
                        Arrays.asList(
                                Arrays.asList(0, 1),
                                Arrays.asList(1, 0)
                        )
                ),
                arguments(new int[]{1, 2, 3},
                        Arrays.asList(
                                Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2),
                                Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1),
                                Arrays.asList(3, 1, 2), Arrays.asList(3, 2, 1)
                        )
                )
        );
    }
}