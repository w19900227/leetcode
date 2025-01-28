package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.TreeNode;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static leetcode.pub.untl.DeepCompare.areListListEqual;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _102_binary_tree_level_order_traversalTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> actual = leetCode.levelOrder(root);
        Assert.assertTrue(areListListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            bfs(result, 1, root);
            return result;
        }

        public void bfs(List<List<Integer>> result, int i, TreeNode node) {
            if (node == null) return;
            if (result.size() < i) {
                result.add(new ArrayList<>());
            }
            result.get(i - 1).add(node.val);
            if (node.left != null) bfs(result, i + 1, node.left);
            if (node.right != null) bfs(result, i + 1, node.right);
        }
    }

    public static class Solution2 implements LeetCode {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            bfs(result, 1, root);
            return result;
        }

        public void bfs(List<List<Integer>> result, int i, TreeNode node) {
            if (node == null) return;
            if (result.size() < i) {
                result.add(new ArrayList<>());
            }
            result.get(i - 1).add(node.val);
            if (node.left != null) bfs(result, i + 1, node.left);
            if (node.right != null) bfs(result, i + 1, node.right);
        }
    }

    public interface LeetCode {
        List<List<Integer>> levelOrder(TreeNode root);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(TreeNode.newTreeNode(3,
                                TreeNode.newTreeNode(9),
                                TreeNode.newTreeNode(20,
                                        TreeNode.newTreeNode(15),
                                        TreeNode.newTreeNode(7)
                                )
                        ),
                        Arrays.asList(Arrays.asList(3),
                                Arrays.asList(9, 20),
                                Arrays.asList(15, 7))
                ),
                arguments(null,
                        Arrays.asList()
                )
        );
    }
}