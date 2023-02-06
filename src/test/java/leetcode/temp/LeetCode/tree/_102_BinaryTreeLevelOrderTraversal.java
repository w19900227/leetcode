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

class _102_BinaryTreeLevelOrderTraversal {

    private final static Test test = new Test2();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> actual = test.levelOrder(root);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(
                                Arrays.asList(3),
                                Arrays.asList(9, 20),
                                Arrays.asList(15, 7))
                ),
                arguments(null,
                        Arrays.asList()
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(
                                Arrays.asList(3),
                                Arrays.asList(9, 20),
                                Arrays.asList(1, 2, 15, 7))
                ),
                arguments(new TreeNode(3),
                        Arrays.asList(
                                Arrays.asList(3))
                ),
                arguments(new TreeNode(3, null, new TreeNode(20)),
                        Arrays.asList(
                                Arrays.asList(3),
                                Arrays.asList(20))
                ),
                arguments(new TreeNode(3, new TreeNode(20), new TreeNode(20)),
                        Arrays.asList(
                                Arrays.asList(3),
                                Arrays.asList(20, 20))
                )
        );
    }

    interface Test {
        List<List<Integer>> levelOrder(TreeNode root);
    }

    static class Test1 implements Test {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            return hepler(root, 0, list);
        }

        private List<List<Integer>> hepler(TreeNode node, int index, List<List<Integer>> list) {
            if (node == null) return list;
            if (list.size() == index) list.add(new ArrayList<>());
            List<Integer> integers = list.get(index);
            integers.add(node.val);
            if (node.left != null) hepler(node.left, index + 1, list);
            if (node.right != null) hepler(node.right, index + 1, list);
            return list;
        }
    }

    static class Test2 implements Test {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> initList = new ArrayList<>();
            if (root == null) return initList;
            helper(initList, 0, root);
            return initList;
        }

        private void helper(List<List<Integer>> initList, int index, TreeNode root) {
            if (root == null) return;
            if (initList.size() == index) initList.add(new ArrayList<>());
            List<Integer> intList = initList.get(index);
            intList.add(root.val);
            helper(initList, index + 1, root.left);
            helper(initList, index + 1, root.right);
        }
    }

    public List<List<String>> test() {
//        https://beginnersbook.com/2013/12/how-to-initialize-an-arraylist/
        List<List<String>> a = new ArrayList<List<String>>() {{
            add(Arrays.asList("1"));
            add(Arrays.asList("1"));
        }};
        return null;
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