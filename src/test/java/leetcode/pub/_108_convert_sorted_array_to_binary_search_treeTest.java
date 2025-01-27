package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.DeepCompare;
import leetcode.pub.untl.TreeNode;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _108_convert_sorted_array_to_binary_search_treeTest {

    private static final LeetCode leetCode = new Solution();

    public static class Solution implements LeetCode {
        @Override
        public TreeNode sortedArrayToBST(int[] nums) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
     *
     * @see Difficulty#Easy()
     * @see Topic#Array()
     * @see Topic#DivideAndConquer()
     * @see Topic#Tree()
     * @see Topic#BinarySearchTree()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(int[] nums, TreeNode expected) {
        TreeNode actual = leetCode.sortedArrayToBST(nums);
        Assert.assertTrue(DeepCompare.areTreesEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        @Override
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            return sortedArray(0, nums.length - 1, nums);
        }

        private TreeNode sortedArray(int start, int end, int[] nums) {
            if (start > end) return null;
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode();
            root.val = nums[mid];
            root.left = sortedArray(start, mid - 1, nums);
            root.right = sortedArray(mid + 1, end, nums);
            return root;
        }
    }

    public interface LeetCode {
        TreeNode sortedArrayToBST(int[] nums);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(new int[]{-10, -3, 0, 5, 9},
                        TreeNode.newTreeNode(
                                0,
                                TreeNode.newTreeNode(-10,
                                        null,
                                        TreeNode.newTreeNode(-3)),
                                TreeNode.newTreeNode(5,
                                        null,
                                        TreeNode.newTreeNode(9)
                                )

                        )
                ),
                arguments(new int[]{1, 3},
                        TreeNode.newTreeNode(1, null, TreeNode.newTreeNode(3))
                )
        );
    }
}