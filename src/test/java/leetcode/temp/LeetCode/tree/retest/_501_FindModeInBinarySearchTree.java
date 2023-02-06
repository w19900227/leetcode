package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _501_FindModeInBinarySearchTree {

    @Test
    public void test1() {
        TreeNode actual = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(2), null));

        int[] treeNode = findMode(actual);
        int[] expected = {2};
        Assert.assertArrayEquals(expected, treeNode);
    }

    @Test
    public void test2() {
        TreeNode actual = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), null));

        int[] treeNode = findMode(actual);
        int[] expected = {3, 2, 1};
        Assert.assertArrayEquals(expected, treeNode);
    }

    public int[] findMode(TreeNode root) {
        return new int[]{0};
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