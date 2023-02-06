package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _653_TwoSum_IV_InputIsABst {
    private final Test test = new Test2();

    static class Test2 implements Test {
        private Set<Integer> intList = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            if (intList.contains(k - root.val)) return true;
            intList.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int k, boolean expected) {
        boolean actual = test.findTarget(root, k);

        Assert.assertEquals(expected, actual);
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

    interface Test {
        boolean findTarget(TreeNode root, int k);
    }

    static class Test1 implements Test {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            List<Integer> intList = helper(new ArrayList(), root);
            if (intList.size() < 2) return false;
            int i = 0, j = intList.size() - 1, init = 0;
            while ((init = intList.get(i) + intList.get(j)) != k) {
                if (k < init) j--;
                else i++;
                if (i >= j) return false;
            }
            return init == k;
        }

        public List<Integer> helper(List<Integer> list, TreeNode root) {
            if (root == null) return list;
            helper(list, root.left);
            list.add(root.val);
            helper(list, root.right);
            return list;
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
