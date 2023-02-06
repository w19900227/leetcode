package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _98_ValidateBinarySearchTree {

    private final static Test validBST = new ValidBST_3();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode treeNode, boolean expected) {
        boolean actual = validBST.isValidBST(treeNode);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        true),
                arguments(new TreeNode(5,
                                new TreeNode(1),
                                new TreeNode(4, new TreeNode(3), new TreeNode(6))),
                        false),
                arguments(new TreeNode(5),
                        true),
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                null),
                        true),
                arguments(new TreeNode(2,
                                null,
                                new TreeNode(3)),
                        true),
                arguments(new TreeNode(2,
                                new TreeNode(3),
                                null),
                        false),
                arguments(new TreeNode(2,
                                null,
                                new TreeNode(1)),
                        false),
                arguments(new TreeNode(4,
                                new TreeNode(3, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(5)),
                        false),
                arguments(new TreeNode(4,
                                new TreeNode(5, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(5)),
                        false),
                arguments(new TreeNode(5,
                                new TreeNode(4),
                                new TreeNode(6, new TreeNode(3), new TreeNode(7))),
                        false),
                arguments(new TreeNode(3,
                                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                                new TreeNode(5, new TreeNode(4), new TreeNode(6))),
                        true),
                arguments(new TreeNode(1, new TreeNode(1), null),
                        false),
                arguments(new TreeNode(32,
                                new TreeNode(26,
                                        new TreeNode(19, null, new TreeNode(27)),
                                        null),
                                new TreeNode(47, null, new TreeNode(56))),
                        false),
                arguments(new TreeNode(1, null, new TreeNode(1)),
                        false),
                arguments(new TreeNode(120,
                                new TreeNode(70,
                                        new TreeNode(50, new TreeNode(20), new TreeNode(55)),
                                        new TreeNode(100, new TreeNode(75), new TreeNode(110))),
                                new TreeNode(140,
                                        new TreeNode(130, new TreeNode(119), new TreeNode(135)),
                                        new TreeNode(160, new TreeNode(150), new TreeNode(200)))),
                        false),
                arguments(new TreeNode(2147483647),
                        true)
        );
    }

    interface Test {
        boolean isValidBST(TreeNode root);
    }

    public static class ValidBST_1 implements Test {
        public boolean isValidBST(TreeNode root) {
            List<Integer> inOrder = new ArrayList<>();
            helper(inOrder, root);
            int i = 1;
            while (i < inOrder.size()) {
                if (!(inOrder.get(i - 1) < inOrder.get(i))) return false;
                i++;
            }
            return true;
        }

        private void helper(List<Integer> inOrder, TreeNode treeNode) {
            if (treeNode == null) return;
            if (treeNode.left != null) helper(inOrder, treeNode.left);
            inOrder.add(treeNode.val);
            helper(inOrder, treeNode.right);
        }
    }

    public static class ValidBST_2 implements Test {
        public boolean isValidBST(TreeNode root) {
            long min = Long.MIN_VALUE;
            long max = Long.MAX_VALUE;
            return compare(root, min, max);
        }

        private boolean compare(TreeNode root, long min, long max) {
            if (root == null) return true;
            if (min >= root.val || root.val >= max) return false;
            return compare(root.left, min, root.val) && compare(root.right, root.val, max);
        }
    }

    static class ValidBST_3 implements Test {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long min, long max) {
            if (root == null) return true;
            boolean left = helper(root.left, min, root.val);
            boolean right = helper(root.right, root.val, max);
            return min < root.val && root.val < max && left && right;
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