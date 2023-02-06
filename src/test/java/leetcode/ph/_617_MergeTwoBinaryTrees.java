package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _617_MergeTwoBinaryTrees {

    private final LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root1, TreeNode root2, TreeNode expected) {
        TreeNode actual = leetCode.mergeTrees(root1, root2);
        Assert.assertTrue(isSameTree(expected, actual));
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static class Solution implements LeetCode {
        @Override
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return null;
        }
    }

    interface LeetCode {
        TreeNode mergeTrees(TreeNode root1, TreeNode root2);
    }

    public static class Test1 implements LeetCode {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            TreeNode result = new TreeNode(root1.val + root2.val);
            result.left = mergeTrees(root1.left, root2.left);
            result.right = mergeTrees(root1.right, root2.right);
            return result;
        }
    }

    /**
     * Test1的效能比Test2好
     */
    public static class Test2 implements LeetCode {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            TreeNode result = new TreeNode(root1.val + root2.val);
            result.left = mergeTrees(root1.left, root2.left);
            result.right = mergeTrees(root1.right, root2.right);
            return result;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1,
                                new TreeNode(3, new TreeNode(5), null),
                                new TreeNode(2)
                        ),
                        new TreeNode(2,
                                new TreeNode(1, null, new TreeNode(4)),
                                new TreeNode(3, null, new TreeNode(7))),
                        new TreeNode(3,
                                new TreeNode(4, new TreeNode(5), new TreeNode(4)),
                                new TreeNode(5, null, new TreeNode(7)))
                ),
                arguments(new TreeNode(1),
                        new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(2, new TreeNode(2), null)
                ),
                arguments(null,
                        null,
                        null
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
