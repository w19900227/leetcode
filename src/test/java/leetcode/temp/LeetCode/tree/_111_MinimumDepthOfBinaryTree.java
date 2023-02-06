package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _111_MinimumDepthOfBinaryTree {

    private final static Test test = new Test3();

    static class Test3 implements Test {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;
            int left = minDepth(root.left) + 1;
            int right = minDepth(root.right) + 1;
            return Math.min(left, right);
        }
    }

    static class Test2 implements Test {
        public int minDepth(TreeNode root) {
            return helper(root, 0);
        }

        public int helper(TreeNode root, int min) {
            if (root == null) return min;
            if (root.left == null) return helper(root.right, min + 1);
            if (root.right == null) return helper(root.left, min + 1);
            int left = helper(root.left, min + 1);
            int right = helper(root.right, min + 1);
            return Math.min(left, right);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, int expected) {
        int treeNode = test.minDepth(root);

        Assert.assertTrue(treeNode == expected);
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

    interface Test {
        int minDepth(TreeNode root);
    }

    static class Test1 implements Test {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;
            int left = (root.left != null) ? minDepth(root.right) + 1 : 0;
            int right = (root.right != null) ? minDepth(root.left) + 1 : 0;
            return left < right ? left : right;
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