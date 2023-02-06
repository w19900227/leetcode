package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _108_ConvertSortedArrayToBinarySearchTree {

    private final Test test = new Test1();

    public static class Test1 implements Test {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            TreeNode treeNode = new TreeNode();
            helper(nums, 0, treeNode);
            return treeNode;
        }

        public TreeNode helper(int[] nums, int index, TreeNode treeNode) {
            if (nums.length < index) return null;
            int idx = index * 2;
            treeNode.val = nums[index];
            treeNode.left = (idx + 1 <= nums.length) ? helper(nums, index + 1, treeNode) : null;
            treeNode.right = (idx + 2 <= nums.length) ? helper(nums, index + 2, treeNode) : null;
            return treeNode;
        }

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(int[] nums, TreeNode expected) {
        TreeNode actual = test.sortedArrayToBST(nums);
        String a = treeConvertToString(actual);
        String e = treeConvertToString(expected);
        Assert.assertEquals(e, a);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{-10, -3, 0, 5, 9},
                        new TreeNode(0,
                                new TreeNode(-3, new TreeNode(-10), null),
                                new TreeNode(9, new TreeNode(5), null))
                ),
                arguments(new int[]{1, 3},
                        new TreeNode(3,
                                new TreeNode(1),
                                null)
                )
        );
    }

    interface Test {
        TreeNode sortedArrayToBST(int[] nums);
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

    public static String treeConvertToString(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        treeConvertToString(root, sb);
        return sb.toString().substring(1);
    }

    public static void treeConvertToString(TreeNode root, StringBuffer sb) {
        if (root == null) return;
        if (root.left != null) treeConvertToString(root.left, sb);
        sb.append("," + root.val);
        if (root.right != null) treeConvertToString(root.right, sb);
    }
}
