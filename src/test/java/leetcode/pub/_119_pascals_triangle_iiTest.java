package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.DeepCompare;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
            return null;
        }
    }

    public interface LeetCode {
        List<Integer> getRow(int rowIndex);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(0,
                        Arrays.asList(1)
                ),
                arguments(1,
                        Arrays.asList(1, 1)
                ),
                arguments(3,
                        Arrays.asList(1, 3, 3, 1)
                )
        );
    }
}