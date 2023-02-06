package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _530_MinimumAbsoluteDifferenceInBST {

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1,
                null,
                new TreeNode(3, new TreeNode(2), null));

        assertMinimumReturnTrue(treeNode, 1);
    }

    @Test
    public void test2() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(2), null));

        assertMinimumReturnTrue(treeNode, -1);
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(4),
                new TreeNode(3, new TreeNode(2), null));

        assertMinimumReturnTrue(treeNode, -3);
    }

    private void assertMinimumReturnTrue(TreeNode treeNode, int expected) {
        int actual = getMinimumDifference(treeNode);
        Assert.assertEquals(expected, actual);
    }

    public int getMinimumDifference(TreeNode root) {
        return 0;
    }

    public class TreeNode {
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