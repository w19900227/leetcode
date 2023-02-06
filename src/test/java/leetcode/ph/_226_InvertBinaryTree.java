package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _226_InvertBinaryTree {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/invert-binary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, TreeNode expected) {
        TreeNode actual = leetCode.invertTree(root);
        Assert.assertTrue(isSameTree(expected, actual));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static class Solution implements LeetCode {
        @Override
        public TreeNode invertTree(TreeNode root) {
            return null;
        }
    }

    interface LeetCode {
        TreeNode invertTree(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    /**
     * 效能最優
     * 速度100% 贏class Test1
     */
    public static class Test2 implements LeetCode {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(3), new TreeNode(2))
                ),
                arguments(new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(1, null, new TreeNode(2))
                ),
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                        new TreeNode(1, new TreeNode(1), new TreeNode(2))
                ),
                arguments(new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(1))
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                                new TreeNode(7, new TreeNode(6), new TreeNode(9))),
                        new TreeNode(4,
                                new TreeNode(7, new TreeNode(9), new TreeNode(6)),
                                new TreeNode(2, new TreeNode(3), new TreeNode(1)))
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
