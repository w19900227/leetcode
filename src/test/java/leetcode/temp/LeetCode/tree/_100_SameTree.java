package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _100_SameTree {
    private final static Test test = new Test_1();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode p, TreeNode q, boolean expected) {
        boolean actual = test.isSameTree(p, q);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        true),
                arguments(new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(1, null, new TreeNode(2)),
                        false),
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                        new TreeNode(1, new TreeNode(1), new TreeNode(2)),
                        false)
        );
    }

    interface Test {
        boolean isSameTree(TreeNode p, TreeNode q);
    }

    static class Test_1 implements Test {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    static class Test_2 implements Test {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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