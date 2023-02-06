package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _226_InvertBinaryTree {

    public int[] t() {
        return new int[]{};
    }

    @Test
    public void test1() {
        TreeNode resultTreeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        TreeNode actual = invertTree(resultTreeNode);
        TreeNode expected = new TreeNode(4,
                new TreeNode(7, new TreeNode(9), new TreeNode(6)),
                new TreeNode(2, new TreeNode(3), new TreeNode(1)));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode resultTreeNode = new TreeNode(1,
                new TreeNode(2),
                null);

        TreeNode actual = invertTree(resultTreeNode);
        TreeNode expected = new TreeNode(1,
                null,
                new TreeNode(2));

        Assert.assertEquals(expected, actual);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
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