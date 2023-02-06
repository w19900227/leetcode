package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _113_PathSum_II {

    private final Test test = new Test2();

    static class Test2 implements Test {
        public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
            List<List<Integer>> resultList = new ArrayList<>();
            List<Integer> sumList = new ArrayList<>();
            helper(resultList, sumList, root, targetSum);
            return resultList;
        }

        public void helper(List<List<Integer>> resultList, List<Integer> sumList, TreeNode root, int targetSum) {
            if (root == null) return;
            targetSum -= root.val;
            sumList.add(root.val);
            helper(resultList, sumList, root.left, targetSum);
            helper(resultList, sumList, root.right, targetSum);
            if (targetSum == 0 && root.left == null && root.right == null) resultList.add(new ArrayList<>(sumList));
            if (0 < sumList.size()) sumList.remove(sumList.size() - 1);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int targetSum, List<List<Integer>> expected) {
        List<List<Integer>> actual = test.hasPathSum(root, targetSum);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(null,
                        0,
                        Arrays.asList(
                        )),
                arguments(new TreeNode(0),
                        0,
                        Arrays.asList(
                                Arrays.asList(0)
                        )),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 8, 4, 5)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(5)))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 8, 4, 5),
                                Arrays.asList(5, 8, 4, 5)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), null)),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(9))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 8, 9)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(9, new TreeNode(1), null))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(2), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(9, new TreeNode(1), null))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 4, 11, 2)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(2), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(9))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 8, 9)
                        )
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4, new TreeNode(11, new TreeNode(2), new TreeNode(2)), null),
                                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(5)))),
                        22,
                        Arrays.asList(
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 4, 11, 2),
                                Arrays.asList(5, 8, 4, 5),
                                Arrays.asList(5, 8, 4, 5)
                        )
                )
        );
    }

    interface Test {
        List<List<Integer>> hasPathSum(TreeNode root, int targetSum);
    }

    static class Test1 implements Test {

        public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> sumList = new ArrayList<>();
            helper(root, sum, list, sumList);
            return list;
        }

        private void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> sumList) {
            if (root == null) return;
            sum = (sum - root.val);
            sumList.add(root.val);
            helper(root.left, sum, list, sumList);
            helper(root.right, sum, list, sumList);
            if (sum == 0 && root.left == null && root.right == null) {
                list.add(new ArrayList<>(sumList));
            }
            if (0 < sumList.size()) sumList.remove(sumList.size() - 1);
            return;
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
