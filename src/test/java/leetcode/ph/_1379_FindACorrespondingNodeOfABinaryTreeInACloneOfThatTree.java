package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    private final LeetCode leetCode = new Test1();

    /**
     * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, TreeNode target, TreeNode expected) {
        TreeNode actual = leetCode.getTargetCopy(root, root, target);
        Assert.assertTrue(isSame(expected, actual));
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static class Solution implements LeetCode {
        @Override
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            return null;
        }
    }

    interface LeetCode {
        TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target);
    }

    public static class Test1 implements LeetCode {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

            if (original == null) return null;
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (original == target) return cloned;
            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            if (left == null) return right;
            else return left;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(
                        new TreeNode(7,
                                new TreeNode(4),
                                new TreeNode(3,
                                        new TreeNode(6),
                                        new TreeNode(19))
                        ),
                        new TreeNode(3),
                        new TreeNode(3)
                ),
                arguments(
                        new TreeNode(7),
                        new TreeNode(7),
                        new TreeNode(7)
                ),
                arguments(
                        new TreeNode(8,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(5,
                                                null,
                                                new TreeNode(4,
                                                        null,
                                                        new TreeNode(3,
                                                                null,
                                                                new TreeNode(2,
                                                                        null,
                                                                        new TreeNode(1))))))
                        ),
                        new TreeNode(4),
                        new TreeNode(4)
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
