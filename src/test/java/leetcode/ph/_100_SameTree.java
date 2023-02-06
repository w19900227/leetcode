package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _100_SameTree {

    private static final LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/same-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode p, TreeNode q, boolean expected) {
        boolean actual = leetCode.isSameTree(p, q);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return false;
        }
    }

    public interface LeetCode {
        boolean isSameTree(TreeNode p, TreeNode q);
    }

    public static class Test1 implements LeetCode {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;
            if (p == null && q == null) return true;
            if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            return false;
        }
    }

    public static class Test2 implements LeetCode {
        //        public boolean isSameTree(TreeNode p, TreeNode q) {
//            if (p == null || q == null) return p == q;
//            if (p.val != q.val) return false;
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    private static Stream<Arguments> source() {
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