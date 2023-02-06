package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _101_SymmetricTree {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/symmetric-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, boolean expected) {
        boolean acutal = leetCode.isSymmetric(root);
        Assert.assertEquals(expected, acutal);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean isSymmetric(TreeNode root) {
            return false;
        }
    }

    interface LeetCode {
        boolean isSymmetric(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compare(root.left, root.right);
        }

        private boolean compare(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;
            if (p.val != q.val) return false;
            return compare(p.left, q.right) && compare(p.right, q.left);
        }
    }

    public static class Test2 implements LeetCode {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compare(root.left, root.right);
        }

        private boolean compare(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            return compare(p.left, q.right) && compare(p.right, q.left);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1,
                                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                                new TreeNode(2, new TreeNode(4), new TreeNode(3))),
                        true),
                arguments(new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(3)),
                                new TreeNode(2, null, new TreeNode(3))),
                        false),
                arguments(new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(3)),
                                new TreeNode(2, new TreeNode(3), null)),
                        true),
                arguments(null,
                        true),
                arguments(new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        false),
                arguments(new TreeNode(1,
                                new TreeNode(0),
                                null),
                        false)
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