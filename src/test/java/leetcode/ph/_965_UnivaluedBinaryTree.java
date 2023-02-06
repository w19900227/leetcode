package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _965_UnivaluedBinaryTree {

    private final LeetCode leetCode = new Test2();

    /**
     * https://leetcode.com/problems/univalued-binary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, boolean expected) {
        boolean actual = leetCode.isUnivalTree(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean isUnivalTree(TreeNode root) {
            return false;
        }
    }

    interface LeetCode {
        boolean isUnivalTree(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            if (root.left != null && root.val != root.left.val) return false;
            if (root.right != null && root.val != root.right.val) return false;
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }

    public static class Test2 implements LeetCode {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            return helper(root.left, root.val) && helper(root.right, root.val);
        }

        public boolean helper(TreeNode root, int v) {
            if (root == null) return true;
            if (root.val != v) return false;
            return isUnivalTree(root);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(
                        new TreeNode(1,
                                new TreeNode(1,
                                        new TreeNode(1),
                                        new TreeNode(1)),
                                new TreeNode(1,
                                        null,
                                        new TreeNode(1))
                        ),
                        true
                ),
                arguments(
                        new TreeNode(2,
                                new TreeNode(2,
                                        new TreeNode(5),
                                        new TreeNode(2)),
                                new TreeNode(2)
                        ),
                        false
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
