package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _543_DiameterOfBinaryTree {

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 3);
    }

    @Test
    public void test2() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 2);
    }

    @Test
    public void test3() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3));

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 3);
    }

    @Test
    public void test4() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(8), null),
                        new TreeNode(5)),
                new TreeNode(3));

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 4);
    }

    @Test
    public void test5() {
        TreeNode treeNode = new TreeNode(1);

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 0);
    }

    @Test
    public void test6() {
        assertDiameterOfBinaryTreeReturnTrue(null, 0);
    }

    @Test
    public void test7() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);

        assertDiameterOfBinaryTreeReturnTrue(treeNode, 1);
    }

    private void assertDiameterOfBinaryTreeReturnTrue(TreeNode treeNode, int expected) {
        int actual = diameterOfBinaryTree(treeNode);
        Assert.assertEquals(expected, actual);
    }

    public int diameterOfBinaryTree(TreeNode root) {
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