package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _783_MinimumDistanceBetweenBSTNodes {

    private final LeetCode leetCode = new Test1();

    /**
     * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinarySearchTree()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int expected) {
        int actual = leetCode.minDiffInBST(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int minDiffInBST(TreeNode root) {
            return 0;
        }
    }

    interface LeetCode {
        int minDiffInBST(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public int minDiffInBST(TreeNode root) {

            return 0;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                null),
                        1
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(6)),
                        1
                ),
                arguments(new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(48,
                                        new TreeNode(12),
                                        new TreeNode(49))),
                        1
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(48,
                                        new TreeNode(12),
                                        new TreeNode(49))),
                        1
                ),
                arguments(new TreeNode(6,
                                new TreeNode(3,
                                        new TreeNode(2, new TreeNode(1), null),
                                        new TreeNode(5)),
                                new TreeNode(8)),
                        1
                ),
                arguments(new TreeNode(6,
                                new TreeNode(3,
                                        new TreeNode(2, new TreeNode(1), null),
                                        new TreeNode(5, new TreeNode(4), null)),
                                new TreeNode(8)),
                        1
                )
        );
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
