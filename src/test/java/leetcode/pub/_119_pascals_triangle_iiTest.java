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

public class _119_pascals_triangle_iiTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public List<Integer> getRow(int rowIndex) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/pascals-triangle-ii
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DynamicProgramming()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int rowIndex, List<Integer> expected) {
        List<Integer> actual = leetCode.getRow(rowIndex);
        Assert.assertTrue(DeepCompare.areListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        @Override
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex == 0) return Arrays.asList(1);
            if (rowIndex == 1) {
                return Arrays.asList(1, 1);
            }
            List<Integer> preRows = getRow(rowIndex - 1);
            if (rowIndex > 1) {
                List<Integer> result = new ArrayList<>();
                result.add(1);
                for (int i = 1; i < rowIndex; i++) {
                    result.add(preRows.get(i - 1) + preRows.get(i));
                }
                result.add(1);
                return result;
            }
            return preRows;
        }
    }

    public interface LeetCode {
        List<Integer> getRow(int rowIndex);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(3,
                        Arrays.asList(1, 3, 3, 1)
                ),
                arguments(2,
                        Arrays.asList(1, 2, 1)
                ),
                arguments(1,
                        Arrays.asList(1, 1)
                ),
                arguments(0,
                        Arrays.asList(1)
                )
        );
    }
}