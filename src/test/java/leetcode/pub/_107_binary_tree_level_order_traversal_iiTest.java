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
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static leetcode.pub.untl.DeepCompare.areListListEqual;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _107_binary_tree_level_order_traversal_iiTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
     *
     * @see Difficulty#Medium()
     * @see Topic#Tree()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, List<List<Integer>> expected) {
        LeetCode leetCode = new Solution1();
        List<List<Integer>> actual = leetCode.levelOrderBottom(root);
        Assert.assertTrue(areListListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        private List<List<Integer>> result = new ArrayList<>();

        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return new ArrayList<>();
            helper(result, root, 1);
            Collections.reverse(result);
            return result;
        }

        private void helper(List<List<Integer>> result, TreeNode root, int index) {
            if (root == null) return;
            if (result.size() < index) {
                result.add(new ArrayList<>());
            }
            result.get(index - 1).add(root.val);
            if (root.left != null) helper(result, root.left, index + 1);
            if (root.right != null) helper(result, root.right, index + 1);
        }
    }

    public interface LeetCode {
        List<List<Integer>> levelOrderBottom(TreeNode root);
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
                        Arrays.asList(Arrays.asList(15, 7),
                                Arrays.asList(9, 20),
                                Arrays.asList(3))
                ),
                arguments(TreeNode.newTreeNode(1),
                        Arrays.asList(Arrays.asList(1))
                ),
                arguments(null,
                        Arrays.asList()
                )
        );
    }
}