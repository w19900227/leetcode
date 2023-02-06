package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _104_MaximumDepthOfBinaryTree {

    private final static Test test = new Test3();

    static class Test3 implements Test {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, int expected) {
        int actual = test.maxDepth(root);
        Assert.assertEquals(expected, actual);
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

    interface Test {
        int maxDepth(TreeNode root);
    }

    static class Test1 implements Test {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return helper(root.left, root.right);
        }

        private int helper(TreeNode p, TreeNode q) {
            if (p == null && q == null) return 1;
            int left = (p != null) ? helper(p.left, p.right) + 1 : 0;
            int right = (q != null) ? helper(q.left, q.right) + 1 : 0;
            return left <= right ? right : left;
        }
    }

    static class Test2 implements Test {
        public int maxDepth(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode root, int maxDepth) {
            if (root == null) return maxDepth;
            int left = helper(root.left, maxDepth + 1);
            int right = helper(root.right, maxDepth + 1);
            return left <= right ? right : left;
        }
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