package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.TreeNode;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static leetcode.pub.untl.DeepCompare.areListListEqual;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _733_flood_fillTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            return new int[][]{};
        }
    }

    /**
     * https://leetcode.com/problems/flood-fill
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#Matrix()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[][] image, int sr, int sc, int color, int[][] expected) {
        int[][] actual = leetCode.floodFill(image, sr, sc, color);
        Assert.assertArrayEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int originalColor = image[sr][sc];
            if (originalColor != color) helper(image, sr, sc, color, originalColor);
            return image;
        }

        private void helper(int[][] image, int x, int y, int newColor, int originalColor) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) return;
            image[x][y] = newColor;
            helper(image, x - 1, y, newColor, originalColor);
            helper(image, x + 1, y, newColor, originalColor);
            helper(image, x, y - 1, newColor, originalColor);
            helper(image, x, y + 1, newColor, originalColor);
        }
    }

    public interface LeetCode {
        int[][] floodFill(int[][] image, int sr, int sc, int color);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
                        1,
                        1,
                        2,
                        new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}
                ),
                arguments(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 0, 1}},
                        1,
                        1,
                        2,
                        new int[][]{{2, 0, 1}, {2, 2, 0}, {2, 0, 1}}
                ),
                arguments(new int[][]{{0, 0, 0}, {0, 0, 0}},
                        0,
                        0,
                        1,
                        new int[][]{{1, 1, 1}, {1, 1, 1}}
                ),
                arguments(new int[][]{{0, 0, 0}, {0, 0, 0}},
                        0,
                        0,
                        0,
                        new int[][]{{0, 0, 0}, {0, 0, 0}}
                )
        );
    }
}