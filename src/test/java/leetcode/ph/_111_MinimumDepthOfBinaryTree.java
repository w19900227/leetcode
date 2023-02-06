package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _111_MinimumDepthOfBinaryTree {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, int expected) {
        int actual = leetCode.minDepth(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int minDepth(TreeNode root) {
            return 0;
        }
    }

    interface LeetCode {
        int minDepth(TreeNode root);
    }

    static class Test1 implements LeetCode {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return helper(root, 0);
        }

        private int helper(TreeNode root, int depth) {
            if (root == null) return depth;
            if (root.right == null) return helper(root.left, depth) + 1;
            if (root.left == null) return helper(root.right, depth) + 1;
            int left = (root.left != null) ? helper(root.left, depth) + 1 : depth;
            int right = (root.right != null) ? helper(root.right, depth) + 1 : depth;
            return Math.min(left, right);
        }
    }

    static class Test2 implements LeetCode {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.right == null) return minDepth(root.left) + 1;
            if (root.left == null) return minDepth(root.right) + 1;
            int left = minDepth(root.left) + 1;
            int right = minDepth(root.right) + 1;
            return Math.min(left, right);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        2
                ),
                arguments(new TreeNode(2, null,
                                new TreeNode(3, null,
                                        new TreeNode(4, null,
                                                new TreeNode(5, null,
                                                        new TreeNode(6))))),
                        5
                ),
                arguments(new TreeNode(1, new TreeNode(2), null),
                        2
                ),
                arguments(new TreeNode(1),
                        1
                ),
                arguments(null,
                        0
                ),
                arguments(new TreeNode(1,
                                new TreeNode(2, new TreeNode(4), null),
                                new TreeNode(3, null, new TreeNode(5))),
                        3
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