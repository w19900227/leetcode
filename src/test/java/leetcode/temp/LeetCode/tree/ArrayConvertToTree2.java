package leetcode.temp.LeetCode.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayConvertToTree2 {

    private TreeNode root = new TreeNode();
    private Integer[] arrayInteger;
    private List<Integer> temp = new ArrayList<>();

    @Test
    void test1() {
        Integer[] d = new Integer[]{1, 2, 3, null, 5, null, 7};
        TreeNode helper = convertToTree(d);
        System.out.println();
    }

    @Test
    void test2() {
        Integer[] d = new Integer[]{1, 2, 3, null, 5, null, 7};
        TreeNode helper = convertToTree(d);
        List<Integer> array = convertToArray(helper);
        System.out.println();
    }

    public List<Integer> convertToArray(TreeNode root) {
        if (root == null) return Arrays.asList();
        return helperToArray(root, 0);
    }

    private List<Integer> helperToArray(TreeNode root, int index) {
        temp.add(index, (root != null) ? root.val : null);
        if (root.left != null) helperToArray(root.left, index + 1);
        if (root.right != null) helperToArray(root.right, index + 2);
        return temp;
    }

    public TreeNode convertToTree(Integer[] integerList) {
        this.arrayInteger = integerList;
        return helper(new TreeNode(), 0);
    }

    private TreeNode helper(TreeNode root, int index) {
        if (arrayInteger.length == 0) return root;
        if (root == null) return null;
        index = index * 2;
        if (arrayInteger.length < index) return null;
        if (arrayInteger.length >= index + 1) {
            root.left = (arrayInteger[index + 1] != null) ? new TreeNode(arrayInteger[index + 1]) : null;
            helper(root.left, index + 1);
        }
        if (arrayInteger.length >= index + 2) {
            root.right = (arrayInteger[index + 2] != null) ? new TreeNode(arrayInteger[index + 2]) : null;
            helper(root.right, index + 2);
        }
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