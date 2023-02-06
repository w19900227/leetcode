package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _112_PathSum {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/path-sum/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, int sum, boolean expected) {
        boolean actual = leetCode.hasPathSum(root, sum);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean hasPathSum(TreeNode root, int sum) {
            return false;
        }
    }

    interface LeetCode {
        boolean hasPathSum(TreeNode root, int sum);
    }

    static class Test1 implements LeetCode {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return root.val == targetSum;
            if (root.right == null) return hasPathSum(root.left, targetSum - root.val);
            if (root.left == null) return hasPathSum(root.right, targetSum - root.val);
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }

    static class Test2 implements LeetCode {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return root.val == targetSum;
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(0),
                        0,
                        true
                ),
                arguments(null,
                        0,
                        false
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))),
                        22,
                        true
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))),
                        20,
                        false
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))),
                        30,
                        false
                ),
                arguments(new TreeNode(1, new TreeNode(2), null),
                        1,
                        false
                ),
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        3,
                        true
                ),
                arguments(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        4,
                        true
                ),
                arguments(new TreeNode(1),
                        1,
                        true
                ),
                arguments(new TreeNode(1,
                                new TreeNode(-2, new TreeNode(1,
                                        new TreeNode(-1), null), new TreeNode(3)),
                                new TreeNode(-3, new TreeNode(-2), null)),
                        -1,
                        true
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
