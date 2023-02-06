package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _107_BinaryTreeLevelOrderTraversal_II {

    private final static Test test = new Test2();

    static class Test2 implements Test {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> initList = new ArrayList<>();
            helper(initList, 0, root);
            Collections.reverse(initList);
            return initList;
        }

        public void helper(List<List<Integer>> initList, int index, TreeNode root) {
            if (root == null) return;
            if (initList.size() == index) initList.add(new LinkedList<>());
            helper(initList, index + 1, root.left);
            helper(initList, index + 1, root.right);
            initList.get(index).add(root.val);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode resultTreeNode, List<List<Integer>> expected) {
        List<List<Integer>> actual = test.levelOrderBottom(resultTreeNode);

        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(
                                Arrays.asList(15, 7),
                                Arrays.asList(9, 20),
                                Arrays.asList(3))
                ),
                arguments(null,
                        Arrays.asList()
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9, new TreeNode(1), new TreeNode(2)),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(
                                Arrays.asList(1, 2, 15, 7),
                                Arrays.asList(9, 20),
                                Arrays.asList(3))
                ),
                arguments(new TreeNode(3),
                        Arrays.asList(
                                Arrays.asList(3))
                ),
                arguments(new TreeNode(3, null, new TreeNode(20)),
                        Arrays.asList(
                                Arrays.asList(20),
                                Arrays.asList(3))
                ),
                arguments(new TreeNode(3, new TreeNode(20), new TreeNode(20)),
                        Arrays.asList(
                                Arrays.asList(20, 20),
                                Arrays.asList(3))
                )
        );
    }

    interface Test {
        List<List<Integer>> levelOrderBottom(TreeNode root);
    }

    static class Test1 implements Test {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return Collections.emptyList();
            List<List<Integer>> result = helper(root, 0, new ArrayList<>());
            Collections.reverse(result);
            return result;
        }

//    private List<List<Integer>> helper(TreeNode node, int index, List<List<Integer>> list) {
//        if (node == null) return list;
//        if (list.size() == index) list.add(index, new ArrayList<>());
//        list.get(index).add(node.val);
//        if (node.left != null) hepler(node.left, index + 1, list);
//        if (node.right != null) hepler(node.right, index + 1, list);
//        return list;
//    }

        public List<List<Integer>> helper(TreeNode node, int index, List<List<Integer>> result) {
            if (node == null) return result;
            if (result.size() == index) result.add(new ArrayList<>());
            result.get(index).add(node.val);
            helper(node.left, index + 1, result);
            helper(node.right, index + 1, result);
            return result;
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