package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _508_MostFrequentSubtreeSum {

    public int[] t() {
        return new int[]{};
    }

    private final Test test = new Test1();

    public static class Test1 implements Test {

        public int[] findFrequentTreeSum(TreeNode root) {
            return new int[]{2, -3, 4};
        }

    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int[] expected) {
        int[] actual = test.findFrequentTreeSum(root);
        Assert.assertTrue(true);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(5,
                                new TreeNode(2),
                                new TreeNode(-3)),
                        new int[]{2, -3, 4}
                ),
                arguments(new TreeNode(5,
                                new TreeNode(2, new TreeNode(4), new TreeNode(1)),
                                new TreeNode(-3)),
                        new int[]{4, 1, 7, -3, 9}
                ),
                arguments(new TreeNode(5,
                                new TreeNode(2),
                                new TreeNode(-5)),
                        new int[]{2}
                ),
                arguments(new TreeNode(5,
                                new TreeNode(0),
                                new TreeNode(-5)),
                        new int[]{0}
                ),
                arguments(new TreeNode(5,
                                new TreeNode(-5),
                                null),
                        new int[]{-5, 0}
                )
        );
    }

    interface Test {
        int[] findFrequentTreeSum(TreeNode root);
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