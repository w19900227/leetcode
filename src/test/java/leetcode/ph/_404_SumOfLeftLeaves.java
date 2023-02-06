package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _404_SumOfLeftLeaves {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/sum-of-left-leaves/
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
        int actual = leetCode.sumOfLeftLeaves(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            return 0;
        }
    }

    interface LeetCode {
        int sumOfLeftLeaves(TreeNode root);
    }

    static class Test1 implements LeetCode {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            return leftLeaves(root.left) + rightLeaves(root.right);
        }

        private int leftLeaves(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return root.val;
            if (root.left == null) return rightLeaves(root.right);
            if (root.right == null) return leftLeaves(root.left);
            return leftLeaves(root.left) + rightLeaves(root.right);
        }

        private int rightLeaves(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return rightLeaves(root.right);
            if (root.right == null) return leftLeaves(root.left);
            return leftLeaves(root.left) + rightLeaves(root.right);
        }
    }

    public static class Test2 implements LeetCode {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            return helper(root.left) + sumOfLeftLeaves(root.right);
        }

        private int helper(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return root.val;
            if (root.right == null) return helper(root.left);
            if (root.left == null) return sumOfLeftLeaves(root.right);
            return helper(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public static class Test3 implements LeetCode {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            if (root.left != null && root.left.left == null && root.left.right == null)
                return root.left.val + sumOfLeftLeaves(root.right);
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1),
                        0
                ),
                arguments(new TreeNode(3),
                        0
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                null),
                        9
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        24
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), null),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        16
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, null, new TreeNode(1)),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        15
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        16
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2,
                                        null, new TreeNode(3))),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        16
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2,
                                        new TreeNode(11), new TreeNode(3))),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        27
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2,
                                        null, new TreeNode(3))),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        16
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
