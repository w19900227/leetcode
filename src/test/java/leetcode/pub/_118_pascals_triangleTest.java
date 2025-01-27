package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.DeepCompare;
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

public class _118_pascals_triangleTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public List<List<Integer>> generate(int numRows) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/pascals-triangle
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DynamicProgramming()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int numRows, List<List<Integer>> expected) {
        List<List<Integer>> actual = leetCode.generate(numRows);
        Assert.assertTrue(DeepCompare.areListListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        @Override
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) return new ArrayList<>();
            if (numRows == 1) {
                List<List<Integer>> result = new ArrayList<>();
                result.add(Arrays.asList(1));
                return result;
            }
            List<List<Integer>> preRows = generate(numRows - 1);
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                newRow.add(1);
            }
            for (int i = 1; i < numRows - 1; i++) {
                newRow.set(i, preRows.get(numRows - 2).get(i - 1) + preRows.get(numRows - 2).get(i));
            }
            preRows.add(newRow);
            return preRows;
        }
    }

    public static class Solution2 implements LeetCode {
        @Override
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) return new ArrayList<>();
            if (numRows == 1) {
                List<List<Integer>> result = new ArrayList<>();
                result.add(Arrays.asList(1));
                return result;
            }

            List<List<Integer>> preRows = generate(numRows - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 1; i < numRows - 1; i++) {
                newRow.add(preRows.get(numRows - 2).get(i - 1) + preRows.get(numRows - 2).get(i));
            }
            newRow.add(1);
            preRows.add(newRow);
            return preRows;
        }
    }

    public interface LeetCode {
        List<List<Integer>> generate(int numRows);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(5,
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(1, 1),
                                Arrays.asList(1, 2, 1),
                                Arrays.asList(1, 3, 3, 1),
                                Arrays.asList(1, 4, 6, 4, 1)
                        )
                ),
                arguments(3,
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(1, 1),
                                Arrays.asList(1, 2, 1)
                        )
                ),
                arguments(2,
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(1, 1)
                        )
                ),
                arguments(1,
                        Arrays.asList(Arrays.asList(1))
                )
        );
    }
}