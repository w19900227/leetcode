package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _200_best_time_to_buy_and_sell_stockTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public int numIslands(char[][] grid) {
            return 0;
        }
    }

    /**
     * https://leetcode.com/problems/number-of-islands
     *
     * @see Difficulty#Medium()
     * @see Topic#Array()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#UnionFind()
     * @see Topic#Matrix()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(char[][] grid, int expected) {
        int actual = leetCode.numIslands(grid);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution1 implements LeetCode {
        @Override
        public int numIslands(char[][] grid) {
            return 0;
        }
    }

    public interface LeetCode {
        int numIslands(char[][] grid);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}
                        },
                        3
                ),
                arguments(new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}
                        },
                        1
                )
        );
    }
}