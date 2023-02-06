package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _993_CousinsInBinaryTree {

    private final LeetCode leetCode = new Test1();

    /**
     * https://leetcode.com/problems/cousins-in-binary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int x, int y, boolean expected) {
        boolean actual = leetCode.isCousins(root, x, y);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean isCousins(TreeNode root, int x, int y) {
            return false;
        }
    }

    interface LeetCode {
        boolean isCousins(TreeNode root, int x, int y);
    }

    public static class Test1 implements LeetCode {

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;
            int helper = helper(root.left, x, y);
            int helper1 = helper(root.right, x, y);
            return helper == helper1 && helper != -1 && helper1 != -1;
        }

        private int helper(TreeNode root, int x, int y) {
            if (root == null) return 0;
            if (root.val == x || root.val == y) return (root.left == null && root.right == null) ? 1 : -1;
            int left = (root.left != null) ? helper(root.left, x, y) + 1 : 0;
            int right = (root.right != null) ? helper(root.right, x, y) + 1 : 0;
            return (left != right) ? Math.max(left, right) : -1;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(4),
                                        null),
                                new TreeNode(3)
                        ),
                        4,
                        3,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(4)),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(5))
                        ),
                        5,
                        4,
                        true
                ),
                arguments(
                        new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(4)),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(5))
                        ),
                        2,
                        3,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3,
                                        new TreeNode(4),
                                        new TreeNode(5))
                        ),
                        4,
                        5,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(4)),
                                new TreeNode(3)
                        ),
                        2,
                        3,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        new TreeNode(3
                                        ),
                                        null
                                )
                        ),
                        1,
                        3,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        new TreeNode(3,
                                                new TreeNode(4),
                                                null
                                        ),
                                        null
                                )
                        ),
                        1,
                        3,
                        false
                ),
                arguments(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(3,
                                                new TreeNode(4),
                                                null
                                        ),
                                        null
                                ),
                                new TreeNode(5,
                                        null,
                                        new TreeNode(6))
                        ),
                        3,
                        6,
                        true
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
