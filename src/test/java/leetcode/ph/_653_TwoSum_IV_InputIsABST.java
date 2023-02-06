package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _653_TwoSum_IV_InputIsABST {

    private final LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
     *
     * @see Difficulty#Easy()
     * @see Topic#HashTable()
     * @see Topic#TwoPointers()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinarySearchTree()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int k, boolean expected) {
        boolean actual = leetCode.findTarget(root, k);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public boolean findTarget(TreeNode root, int k) {
            return false;
        }
    }

    interface LeetCode {
        boolean findTarget(TreeNode root, int k);
    }

    public static class Test1 implements LeetCode {
        private Set<Integer> integerSet = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            if (integerSet.contains(k - root.val)) return true;
            integerSet.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(2,
                                null,
                                new TreeNode(3)),
                        6,
                        false
                ),
                arguments(new TreeNode(2,
                                new TreeNode(0, new TreeNode(-4), new TreeNode(1)),
                                new TreeNode(3)),
                        -1,
                        true
                ),
                arguments(new TreeNode(2,
                                new TreeNode(0, new TreeNode(-1), null),
                                new TreeNode(3)),
                        -1,
                        true
                ),
                arguments(new TreeNode(1),
                        2,
                        false
                ),
                arguments(new TreeNode(6,
                                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                                new TreeNode(7, null, new TreeNode(8))),
                        9,
                        true
                ),
                arguments(new TreeNode(5,
                                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                                new TreeNode(6, null, new TreeNode(7))),
                        9,
                        true
                ),
                arguments(new TreeNode(5,
                                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                                new TreeNode(6, null, new TreeNode(7))),
                        28,
                        false
                ),
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        4,
                        true
                ),
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        1,
                        false
                ),
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        3,
                        true
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
