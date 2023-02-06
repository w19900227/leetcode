package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _1971_FindIfPathExistsInGraph {

    private final LeetCode leetCode = new Test1();

    /**
     * https://leetcode.com/problems/find-if-path-exists-in-graph/
     *
     * @see Difficulty#Easy()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#Graph()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(int n, int[][] edges, int source, int destination, int expected) {
        boolean actual = leetCode.validPath(n, edges, source, destination);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            return false;
        }
    }

    interface LeetCode {
        boolean validPath(int n, int[][] edges, int source, int destination);
    }

    public static class Test1 implements LeetCode {
        public boolean validPath(int n, int[][] edges, int source, int destination) {

//            Queue<int[][]> a = new LinkedList<int[][]>(edges);
//            return validPath(n, edges, destination, source);
            return false;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(
                        3,
                        new int[][]{{0, 1}, {1, 2}, {2, 0}},
                        0,
                        2,
                        true
                ),
                arguments(
                        6,
                        new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}},
                        0,
                        5,
                        false
                )
        );
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
