package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _530_MinimumAbsoluteDifferenceInBST {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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
    public void test(TreeNode root, int expected) {
        int actual = leetCode.getMinimumDifference(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int getMinimumDifference(TreeNode root) {
            return 0;
        }
    }

    interface LeetCode {
        int getMinimumDifference(TreeNode root);
    }

    static class Test1 implements LeetCode {
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            List<Integer> integerList = new ArrayList<>();
            helper(root, integerList);
            int i = 1;
            int min = Integer.MAX_VALUE;
            while (i < integerList.size()) {
                min = Math.min(integerList.get(i) - integerList.get(i - 1), min);
                i++;
            }
            return min;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) return;
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
            return;
        }
    }

    static class Test2 implements LeetCode {
        private Integer min = Integer.MAX_VALUE;
        private Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return min;
            getMinimumDifference(root.left);
            if (prev != null) {
                min = Math.min(min, Math.abs(root.val - prev));
            }
            prev = root.val;
            getMinimumDifference(root.right);
            return min;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                        1
                ),
                arguments(new TreeNode(2, new TreeNode(0), new TreeNode(3)),
                        1
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1), new TreeNode(3)),
                                new TreeNode(6)),
                        1
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2),
                                new TreeNode(6)),
                        2
                ),
                arguments(new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(6)),
                        2
                ),
                arguments(new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(7)),
                        3
                ),
                arguments(new TreeNode(4,
                                new TreeNode(2,
                                        null, new TreeNode(3)),
                                new TreeNode(6)),
                        1
                ),
                arguments(new TreeNode(5,
                                new TreeNode(4,
                                        new TreeNode(3, new TreeNode(2), null),
                                        null),
                                new TreeNode(6)),
                        1
                ),
                arguments(new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(48,
                                        new TreeNode(12), new TreeNode(49))),
                        1
                ),
                arguments(new TreeNode(236,
                                new TreeNode(104,
                                        null, new TreeNode(227)),
                                new TreeNode(701,
                                        null, new TreeNode(911))),
                        9
                ),
                arguments(new TreeNode(300,
                                new TreeNode(227,
                                        null, new TreeNode(236)),
                                new TreeNode(701,
                                        null, new TreeNode(911))),
                        9
                )
        );
    }

//    public static class TreeNodeUtil {
//        public static Tree convertArrayToTree(int[] arr, T<Tree> tree) {
//            if (arr.length == 0) return tree;
//            tree.setVal(arr[0]);
//            TreeNodeUtil.helper(arr, tree, 1);
//            return tree;
//        }
//
//        public static void helper(int[] arr, Tree tree, int index) {
//            tree.setLeft(new TreeNode(arr[index * 2]));
//            tree.setRight(arr[index * 2 + 1]);
//        }
//
//        public interface Tree {
//            void setVal(int val);
//
//            void setLeft(int val);
//
//            void setRight(int val);
//        }
//    }

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
