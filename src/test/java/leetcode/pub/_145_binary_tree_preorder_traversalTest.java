package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.DeepCompare;
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

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _145_binary_tree_preorder_traversalTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-postorder-traversal
     *
     * @see Difficulty#Easy()
     * @see Topic#Stack()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(TreeNode root, List<Integer> expected) {
        LeetCode leetCode = new Solution1();
        List<Integer> actual = leetCode.postorderTraversal(root);
        Assert.assertTrue(DeepCompare.areListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        public List<Integer> result = new ArrayList<>();

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return result;
            if (root.left != null) postorderTraversal(root.left);
            if (root.right != null) postorderTraversal(root.right);
            result.add(root.val);
            return result;
        }
    }

    public interface LeetCode {
        List<Integer> postorderTraversal(TreeNode root);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(TreeNode.newTreeNode(1,
                                TreeNode.newTreeNode(2,
                                        TreeNode.newTreeNode(4),
                                        TreeNode.newTreeNode(5,
                                                TreeNode.newTreeNode(6),
                                                TreeNode.newTreeNode(7)
                                        )
                                ),
                                TreeNode.newTreeNode(3,
                                        null,
                                        TreeNode.newTreeNode(8,
                                                TreeNode.newTreeNode(9),
                                                null)
                                )
                        ),
                        Arrays.asList(4, 6, 7, 5, 2, 9, 8, 3, 1)
                ),
                arguments(TreeNode.newTreeNode(1,
                                null,
                                TreeNode.newTreeNode(2,
                                        TreeNode.newTreeNode(3),
                                        null
                                )
                        ),
                        Arrays.asList(3, 2, 1)
                ),
                arguments(TreeNode.newTreeNode(1,
                                null,
                                TreeNode.newTreeNode(2,
                                        null,
                                        TreeNode.newTreeNode(3)
                                )
                        ),
                        Arrays.asList(3, 2, 1)
                ),
                arguments(null,
                        Arrays.asList()
                ),
                arguments(TreeNode.newTreeNode(1),
                        Arrays.asList(1)
                )
        );
    }
}