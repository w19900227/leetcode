package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _104_MaximumDepthOfBinaryTree {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
        int actual = leetCode.maxDepth(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int maxDepth(TreeNode root) {
            return 0;
        }
    }

    interface LeetCode {
        int maxDepth(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return helper(root, 1);
        }

        private int helper(TreeNode root, int depth) {
            if (root == null) return depth;
            int left = (root.left != null) ? helper(root.left, depth + 1) : depth;
            int right = (root.right != null) ? helper(root.right, depth + 1) : depth;
            return (left < right) ? right : left;
        }
    }

    public static class Test2 implements LeetCode {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public static class Test3 implements LeetCode {

        @Override
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return maxDepth(root.right) + 1;
            if (root.right == null) return maxDepth(root.left) + 1;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        3
                ),
                arguments(new TreeNode(1,
                                new TreeNode(2),
                                null),
                        2
                ),
                arguments(new TreeNode(1),
                        1
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