package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _404_SumOfLeftLeaves {

    @Test
    public void test1() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 24);
    }

    @Test
    public void test2() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9, new TreeNode(1), null),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 16);
    }

    @Test
    public void test3() {
        assertSameNumberTrue(null, 0);
    }

    @Test
    public void test4() {
        TreeNode resultTreeNode = new TreeNode(3);

        assertSameNumberTrue(resultTreeNode, 0);
    }

    @Test
    public void test5() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9),
                null);

        assertSameNumberTrue(resultTreeNode, 9);
    }

    @Test
    public void test6() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(1, new TreeNode(4), null),
                        new TreeNode(2)),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 19);
    }

    @Test
    public void test7() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(1, new TreeNode(4), new TreeNode(5)),
                        new TreeNode(2)),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 19);
    }

    @Test
    public void test8() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(1, new TreeNode(4), new TreeNode(5)),
                        new TreeNode(2, new TreeNode(6), null)),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 25);
    }

    @Test
    public void test9() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9,
                        new TreeNode(1, new TreeNode(4), new TreeNode(5)),
                        new TreeNode(2, new TreeNode(6), new TreeNode(7))),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertSameNumberTrue(resultTreeNode, 25);
    }

    @Test
    public void test10() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9, new TreeNode(1), new TreeNode(2)),
                new TreeNode(20, new TreeNode(7), new TreeNode(15)));

        assertSameNumberTrue(resultTreeNode, 8);
    }

    @Test
    public void test11() {
        TreeNode resultTreeNode = new TreeNode(3,
                new TreeNode(9, null, new TreeNode(2)),
                new TreeNode(20, new TreeNode(7), new TreeNode(15)));

        assertSameNumberTrue(resultTreeNode, 7);
    }

    private void assertSameNumberTrue(TreeNode node, int expected) {
        int actual = sumOfLeftLeaves(node);

        Assert.assertEquals(expected, actual);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
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