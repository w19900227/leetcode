package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _637_AverageOfLevelsInBinaryTree {

    private final LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/average-of-levels-in-binary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#BinaryTree()
     */
    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, List<Double> expected) {
        List<Double> actual = leetCode.averageOfLevels(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            return null;
        }
    }

    interface LeetCode {
        List<Double> averageOfLevels(TreeNode root);
    }

    public static class Test1 implements LeetCode {
        public List<Double> averageOfLevels(TreeNode root) {
            List<List<Double>> data = helper(root, new ArrayList<>(), 0);
            List<Double> result = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                double r = 0d;
                for (int j = 0; j < data.get(i).size(); j++) {
                    r += data.get(i).get(j);
                }
                int size = data.get(i).size();
                result.add(i, r / size);
            }
            return result;
        }

        private List<List<Double>> helper(TreeNode root, List<List<Double>> result, int index) {
            if (root == null) return result;
            if (result.size() <= index) result.add(new ArrayList<>());
            List<Double> valList = result.get(index);
            valList.add((double) root.val);
            helper(root.left, result, index + 1);
            helper(root.right, result, index + 1);
            return result;
        }
    }

    public static class Test2 implements LeetCode {
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) return new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            List<Double> list = new ArrayList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
                list.add(sum / size);
            }
            return list;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(25),
                                        new TreeNode(17)
                                ),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                )
                        ),
                        Arrays.asList(3.00000, 14.50000, 16.00000)
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(25),
                                        new TreeNode(17)
                                ),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        null
                                )
                        ),
                        Arrays.asList(3.00000, 14.50000, 19.00000)
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(25),
                                        new TreeNode(17)
                                ),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(0)
                                )
                        ),
                        Arrays.asList(3.00000, 14.50000, 14.25000)
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                )
                        ),
                        Arrays.asList(3.00000, 14.50000, 11.00000)
                ),
                arguments(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                ),
                                new TreeNode(20)
                        ),
                        Arrays.asList(3.00000, 14.50000, 11.00000)
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
