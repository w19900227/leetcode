package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _94_BinaryTreeInorderTraversal {

    private final static Test test = new Test1();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode treeNode, List<Integer> expected) {
        List<Integer> actual = test.inorderTraversal(treeNode);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(1,
                                null,
                                new TreeNode(2, new TreeNode(3), null)),
                        Arrays.asList(1, 3, 2)),
                arguments(null, Arrays.asList()),
                arguments(new TreeNode(1),
                        Arrays.asList(1)),
                arguments(new TreeNode(1,
                                new TreeNode(2),
                                null),
                        Arrays.asList(2, 1)),
                arguments(new TreeNode(1,
                                null,
                                new TreeNode(2)),
                        Arrays.asList(1, 2)),
                arguments(new TreeNode(1,
                                null,
                                new TreeNode(2, new TreeNode(3), new TreeNode(4))),
                        Arrays.asList(1, 3, 2, 4)),
                arguments(new TreeNode(1,
                                new TreeNode(5),
                                new TreeNode(2, new TreeNode(3), new TreeNode(4))),
                        Arrays.asList(5, 1, 3, 2, 4)),
                arguments(new TreeNode(1,
                                new TreeNode(5, new TreeNode(3), new TreeNode(4)),
                                new TreeNode(2)),
                        Arrays.asList(3, 5, 4, 1, 2))
        );
    }

    interface Test {
        List<Integer> inorderTraversal(TreeNode root);
    }

    static class Test1 implements Test {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) return;
            if (root.left != null) helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
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