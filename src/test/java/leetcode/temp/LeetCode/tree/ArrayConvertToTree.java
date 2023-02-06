package leetcode.temp.LeetCode.tree;

class ArrayConvertToTree {

    public TreeNode convertTo(Integer[] integerList) {
        TreeNode treeNode = new TreeNode(integerList[0]);
        return helper(integerList, 0, treeNode);
    }

    private TreeNode helper(Integer[] integerList, int index, TreeNode treeNode) {
        if (treeNode == null) return null;
        index = index * 2;
        if (integerList.length < index) return null;
        if (integerList.length >= index + 1) {
            treeNode.left = (integerList[index + 1] != null) ? new TreeNode(integerList[index + 1]) : null;
            helper(integerList, index + 1, treeNode.left);
        }
        if (integerList.length >= index + 2) {
            treeNode.right = (integerList[index + 2] != null) ? new TreeNode(integerList[index + 2]) : null;
            helper(integerList, index + 2, treeNode.right);
        }
        return treeNode;

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