package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _572_SubtreeOfAnotherTree {

    private static final Test test = new Test2();

    public static class Test2 implements Test {

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return true;
        }
    }

    public static class Test1 implements Test {

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == subRoot) return true;
            if (root == null || subRoot == null) return false;
            if (isSubtreeHelper(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {
            if (root == subRoot) return true;
            if (root == null || subRoot == null) return false;
            if (root.val != subRoot.val) return false;
            return isSubtreeHelper(root.left, subRoot.left) && isSubtreeHelper(root.right, subRoot.right);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, TreeNode subRoot, boolean expected) {
        boolean actual = test.isSubtree(root, subRoot);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                        true
                ),
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(5, new TreeNode(1), new TreeNode(2))),
                        new TreeNode(5, new TreeNode(1), new TreeNode(2)),
                        true
                ),
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(3)), new TreeNode(2)),
                                new TreeNode(5, new TreeNode(1), new TreeNode(2))),
                        new TreeNode(1, new TreeNode(0), new TreeNode(3)),
                        true
                ),
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(3)), new TreeNode(2)),
                                new TreeNode(5, new TreeNode(1), new TreeNode(2))),
                        new TreeNode(4,
                                new TreeNode(1, new TreeNode(0), new TreeNode(3)),
                                new TreeNode(2)),
                        true
                ),
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)),
                                new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                        false
                ),
                arguments(new TreeNode(1),
                        new TreeNode(1),
                        true
                ),
                arguments(new TreeNode(1,
                                new TreeNode(1),
                                null),
                        new TreeNode(1,
                                new TreeNode(1),
                                null),
                        true
                ),
                arguments(new TreeNode(1,
                                new TreeNode(1),
                                null),
                        new TreeNode(1),
                        true
                ),
                arguments(new TreeNode(3,
                                new TreeNode(4, new TreeNode(1), null),
                                new TreeNode(5, new TreeNode(2), null)),
                        new TreeNode(3, new TreeNode(1), new TreeNode(2)),
                        false
                )
        );
    }

    interface Test {
        boolean isSubtree(TreeNode root, TreeNode subRoot);
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