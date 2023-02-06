package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _463_IslandPerimeter {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/island-perimeter/
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#Matrix()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[][] grid, int expected) {
        int actual = leetCode.islandPerimeter(grid);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int islandPerimeter(int[][] grid) {
            return 0;
        }
    }

    interface LeetCode {
        int islandPerimeter(int[][] grid);
    }

    public static class Test1 implements LeetCode {

        public int islandPerimeter(int[][] grid) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 1) return helper(grid, row, col);
                }
            }
            return 0;
        }

        private int helper(int[][] grid, int row, int col) {
            if (!(0 <= row && row < grid.length) ||
                    !(0 <= col && col < grid[row].length)) return 1;
            if (grid[row][col] == -1) return 0;
            if (grid[row][col] == 0) return 1;
            int count = 0;
            grid[row][col] = -1;
            count += helper(grid, row, col - 1);
            count += helper(grid, row - 1, col);
            count += helper(grid, row, col + 1);
            count += helper(grid, row + 1, col);
            return count;
        }
    }

    public static class Test2 implements LeetCode {

        public int islandPerimeter(int[][] grid) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 1) return helper(grid, row, col);
                }
            }
            return 0;
        }

        private int helper(int[][] grid, int row, int col) {
            if (!(0 <= row && row < grid.length) ||
                    !(0 <= col && col < grid[row].length)) return 1;
            if (grid[row][col] == -1) return 0;
            if (grid[row][col] == 0) return 1;
            int count = 0;
            grid[row][col] = -1;
            count += helper(grid, row - 1, col);
            count += helper(grid, row, col - 1);
            count += helper(grid, row, col + 1);
            count += helper(grid, row + 1, col);
            return count;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[][]{{1}},
                        4
                ),
                arguments(new int[][]{{1, 0}},
                        4
                ),
                arguments(new int[][]{{1, 1}},
                        6
                ),
                arguments(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}},
                        14
                ),
                arguments(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}},
                        14
                ),
                arguments(new int[][]{{0, 0, 1, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}},
                        14
                ),
                arguments(new int[][]{{1, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}},
                        14
                ),
                arguments(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}},
                        14
                ),
                arguments(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}},
                        16
                ),
                arguments(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}},
                        12
                ),
                arguments(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}},
                        12
                )
        );
    }

}
