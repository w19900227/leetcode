package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _437_PathSum_III {

    private final Test test = new Test1();

    static class Test2 implements Test {
        private int sum = 0;
        private List<List<Integer>> result = new ArrayList<>();

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            helper(root, targetSum, 0, new ArrayList<>());
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            System.out.println(result);
            return sum;
        }

        private void helper(TreeNode root, int targetSum, int currentSum, List<Integer> recordList) {
            if (root == null) return;
            if (targetSum < currentSum) return;
            currentSum += root.val;
            recordList.add(root.val);
            if (targetSum == currentSum) {
                sum++;
                result.add(recordList);
            }
            helper(root.left, targetSum, currentSum, new ArrayList<>(recordList));
            helper(root.right, targetSum, currentSum, new ArrayList<>(recordList));

        }
    }


    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int targetSum, int expected) {
        int actual = test.pathSum(root, targetSum);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(10,
                                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                                new TreeNode(-3, null, new TreeNode(11))),
                        8,
                        3
                ),
                arguments(new TreeNode(10,
                                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, new TreeNode(1), new TreeNode(1))),
                                new TreeNode(-3, null, new TreeNode(11))),
                        8,
                        4
                ),
                arguments(new TreeNode(10,
                                new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(-2)), new TreeNode(1, null, new TreeNode(1))),
                                new TreeNode(-3, null, new TreeNode(11))),
                        8,
                        2
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)), new TreeNode(4))
                        ),
                        22,
                        3
                )

        );
    }

    interface Test {
        int pathSum(TreeNode root, int targetSum);
    }

    public static class Test1 implements Test {
        private int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            helper(root, targetSum, 0);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return count;
        }

        private void helper(TreeNode root, int targetSum, int sum) {
            if (root == null) return;
            if ((sum += root.val) == targetSum) count++;
            helper(root.left, targetSum, sum);
            helper(root.right, targetSum, sum);
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
