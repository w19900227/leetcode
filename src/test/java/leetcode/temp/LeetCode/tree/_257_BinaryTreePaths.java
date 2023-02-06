package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _257_BinaryTreePaths {

    private final Test test = new Test2();

    static class Test2 implements Test {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> resultList = new ArrayList<>();
            helper(resultList, "", root);
            return resultList;
        }

        private void helper(List<String> resultList, String path, TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) resultList.add(path + root.val);
            if (root.left != null) helper(resultList, path + root.val + "->", root.left);
            if (root.right != null) helper(resultList, path + root.val + "->", root.right);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, List<String> expected) {
        List<String> actual = test.binaryTreePaths(root);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(5)),
                                new TreeNode(3)),
                        Arrays.asList(
                                "1->2->5",
                                "1->3")
                ),
                arguments(new TreeNode(1,
                                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                                new TreeNode(3)),
                        Arrays.asList(
                                "1->2->4",
                                "1->2->5",
                                "1->3")
                ),
                arguments(null,
                        Arrays.asList()
                ),
                arguments(new TreeNode(1),
                        Arrays.asList("1")
                ),
                arguments(new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(2)),
                        Arrays.asList(
                                "1->2",
                                "1->2")
                )
        );
    }

    interface Test {
        List<String> binaryTreePaths(TreeNode root);
    }

    static class Test1 implements Test {
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return Collections.emptyList();
            List<String> result = new ArrayList<>();
            helper(root, new ArrayList<>(), result);
            return result;
        }

        private void helper(TreeNode node, List<String> intList, List<String> result) {
            if (node == null) return;
            intList.add(String.valueOf(node.val));
            helper(node.left, intList, result);
            helper(node.right, intList, result);
            if (node.left == null && node.right == null) result.add(String.join("->", intList));
            if (0 < intList.size()) intList.remove(intList.size() - 1);
        }
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