package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _687_LongestUnivaluePath {

    private static final Test test = new Test1();

    public static class Test1 implements Test {

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            return helper(root, root) - 1;
        }

        private int helper(TreeNode treeNode, TreeNode p) {
            if (treeNode == null) return 0;
            int count = 0;
            if (treeNode.val == p.val) count = 1;
            int l = helper(treeNode.left, treeNode) + count;
            int r = helper(treeNode.right, treeNode) + count;
            return Math.max(l, r);
        }

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int expected) {
        int actual = test.longestUnivaluePath(root);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(5,
                                new TreeNode(4),
                                null),
                        0
                ),
                arguments(new TreeNode(5,
                                null,
                                new TreeNode(5)),
                        1
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4),
                                new TreeNode(5)),
                        1
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
                                new TreeNode(5, null, new TreeNode(5))),
                        2
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
                                new TreeNode(5)),
                        1
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
                                new TreeNode(5, new TreeNode(5), null)),
                        2
                ),
                arguments(new TreeNode(1,
                                new TreeNode(4, new TreeNode(4), new TreeNode(4)),
                                new TreeNode(5, null, new TreeNode(5))),
                        2
                ),
                arguments(new TreeNode(1,
                                new TreeNode(4, new TreeNode(4, new TreeNode(4), null), new TreeNode(4)),
                                new TreeNode(5, null, new TreeNode(5))),
                        3
                )
        );
    }

    interface Test {
        int longestUnivaluePath(TreeNode root);
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