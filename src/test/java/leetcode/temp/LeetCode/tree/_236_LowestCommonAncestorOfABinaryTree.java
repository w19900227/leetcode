package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _236_LowestCommonAncestorOfABinaryTree {

    private static final Test test = new Test2();

    public static class Test2 implements Test {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return (left != null) ? (right != null) ? root : left : right;
        }
    }

    public static class Test1 implements Test {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root.val == p.val || root.val == q.val) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            return (left != null) ? left : right;
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, TreeNode p, TreeNode q, TreeNode expectedNode) {
        TreeNode actual = test.lowestCommonAncestor(root, p, q);
        Assert.assertEquals(expectedNode.val, actual.val);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                new TreeNode(1, new TreeNode(0), new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                arguments(new TreeNode(3,
                                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                                new TreeNode(1, new TreeNode(0), new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                arguments(new TreeNode(1,
                                new TreeNode(2),
                                null),
                        new TreeNode(1),
                        new TreeNode(2),
                        new TreeNode(1)
                )
        );
    }

    interface Test {
        TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
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