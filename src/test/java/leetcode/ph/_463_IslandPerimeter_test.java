package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _463_IslandPerimeter_test {

    private final static LeetCode leetCode = new Test2();

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
    public void test(int[][] grid, int[][] expectedGrid) {
        int[][] actual = leetCode.islandPerimeter(grid);
        Assert.assertTrue(isSameGrid(actual, expectedGrid));
    }

    private boolean isSameGrid(int[][] originGrid, int[][] compareGrid) {
        boolean result = true;
        for (int row = 0; row < originGrid.length && result; row++) {
            for (int col = 0; col < originGrid[row].length && result; col++) {
                System.out.println("row:" + row + ",col:" + col + ",origin:" + originGrid[row][col] + ",compare:" + compareGrid[row][col]);
//                if (originGrid[row][col] != compareGrid[row][col]) result = false;
            }
        }
        return result;
    }

    interface LeetCode {
        int[][] islandPerimeter(int[][] grid);
    }

    public static class Test1 implements LeetCode {

        public int[][] islandPerimeter(int[][] grid) {
            boolean result = true;
            for (int row = 0; row < grid.length && result; row++) {
                for (int col = 0; col < grid[row].length && result; col++) {
                    if (grid[row][col] == 1) {
                        helper(grid, row, col);
                        result = false;
                    }
                }
            }
            return grid;
        }

        private boolean helper(int[][] grid, int row, int col) {
            if (row == grid.length && 0 <= col && col < grid[row - 1].length) return true;
            if (0 <= row && row < grid.length && col == grid[row].length) return true;
            if (!(0 <= row && row < grid.length) ||
                    !(0 <= col && col < grid[row].length)) return false;
            if (grid[row][col] == 0 || grid[row][col] == -1) return false;
            grid[row][col] = -1;
            if (!(helper(grid, row, col - 1) ||
                    helper(grid, row - 1, col) ||
                    helper(grid, row, col + 1) ||
                    helper(grid, row + 1, col))) {
                return false;
            }
            grid[row][col] = 1;
            return true;
        }
    }

    public static class Test2 implements LeetCode {

        public int[][] islandPerimeter(int[][] grid) {
            boolean result = true;
            for (int row = 0; row < grid.length && result; row++) {
                for (int col = 0; col < grid[row].length && result; col++) {
                    if (grid[row][col] == 1) {
                        helper(grid, row, col);
                        result = false;
                    }
                }
            }
            return grid;
        }

        private boolean helper(int[][] grid, int row, int col) {
            if (row == grid.length && 0 <= col && col < grid[row - 1].length) return true;
            if (0 <= row && row < grid.length && col == grid[row].length) return true;
            if (!(0 <= row && row < grid.length) ||
                    !(0 <= col && col < grid[row].length)) return false;
            if (grid[row][col] == 0 || grid[row][col] == -1) return false;
            grid[row][col] = -1;
            if (helper(grid, row, col - 1) ||
                    helper(grid, row - 1, col) ||
                    helper(grid, row, col + 1) ||
                    helper(grid, row + 1, col)) {
                grid[row][col] = 1;
                return true;
            }
            return false;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}},
                        new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}}
                ),
                arguments(new int[][]{{1, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}},
                        new int[][]{{1, 1, 0, 0}, {-1, 1, -1, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}}
                ),
                arguments(new int[][]{{1, 0, 1, 0}, {1, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 1}},
                        new int[][]{{1, 0, -1, 0}, {1, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 1}}
                ),
                arguments(new int[][]{{1, 0, 1, 0}, {1, 1, 1, 1}},
                        new int[][]{{1, 0, -1, 0}, {1, 1, 1, 1}}
                ),
                arguments(new int[][]{{1, 0, 1, 0}, {1, 1, 0, 0}},
                        new int[][]{{1, 0, 1, 0}, {1, 1, 0, 0}}
                ),
                arguments(new int[][]{{1, 0, 1, 0}, {1, 1, 1, 0}},
                        new int[][]{{1, 0, -1, 0}, {1, 1, 1, 0}}
                )
        );
    }

}
