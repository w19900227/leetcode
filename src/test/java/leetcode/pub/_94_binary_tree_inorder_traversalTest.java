package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.DeepCompare;
import leetcode.pub.untl.TreeNode;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _94_binary_tree_inorder_traversalTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal
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
        List<Integer> actual = leetCode.inorderTraversal(root);
        Assert.assertTrue(DeepCompare.areListEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            return null;
        }
    }

    public interface LeetCode {
        List<Integer> inorderTraversal(TreeNode root);
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
                        new int[]{4, 2, 6, 5, 7, 1, 3, 9, 8}
                ),
                arguments(TreeNode.newTreeNode(1,
                                null,
                                TreeNode.newTreeNode(2,
                                        TreeNode.newTreeNode(3),
                                        null
                                )
                        ),
                        new int[]{1, 3, 2}
                ),
//                arguments(null,
//                        new int[]{}
//                ),
                arguments(TreeNode.newTreeNode(1),
                        1
                )
        );
    }
}