package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _733_FloodFill {

    private final static LeetCode leetCode = new Test1();

    /**
     * https://leetcode.com/problems/flood-fill/
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#Matrix()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[][] image, int sr, int sc, int color, int expected) {
        int[][] actual = leetCode.floodFill(image, sr, sc, color);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            return new int[0][];
        }
    }

    interface LeetCode {
        int[][] floodFill(int[][] image, int sr, int sc, int color);
    }

    public static class Test1 implements LeetCode {

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            return null;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2,
                        new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}
                ),
                arguments(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0,
                        new int[][]{{0, 0, 0}, {0, 0, 0}}
                )
        );
    }

}
