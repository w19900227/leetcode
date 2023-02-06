package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _2096_StepByStep_DirectionsFromABinaryTreeNodeToAnother {

    private final Test test = new Test2();

    public static class Test2 implements Test {

        public String getDirections(TreeNode root, int startValue, int destValue) {
            if (root == null) return "";
            return "";
        }
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TreeNode root, int startValue, int destValue, String expected) {
        String actual = test.getDirections(root, startValue, destValue);
        Assert.assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new TreeNode(10,
                                new TreeNode(1, new TreeNode(3), null),
                                new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                        3,
                        6,
                        "UURL"
                ),
                arguments(new TreeNode(10,
                                new TreeNode(1, new TreeNode(3), null),
                                new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                        6,
                        3,
                        "UULL"
                ),
                arguments(new TreeNode(10,
                                new TreeNode(1, new TreeNode(3), null),
                                new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                        1,
                        2,
                        "UR"
                ),
                arguments(new TreeNode(10,
                                new TreeNode(1, new TreeNode(3), null),
                                new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                        4,
                        6,
                        "UL"
                ),
                arguments(new TreeNode(2,
                                new TreeNode(1, new TreeNode(3), new TreeNode(4)),
                                null),
                        2,
                        4,
                        "LR"
                ),
                arguments(new TreeNode(2,
                                new TreeNode(1),
                                null),
                        2,
                        1,
                        "L"
                )

        );
    }

    static class Test1 implements Test {

        public String getDirections(TreeNode root, int startValue, int destValue) {
            if (root == null) return "";
            StringBuffer startToRoot = new StringBuffer(), endToRoot = new StringBuffer();

            helper(root, startValue, startToRoot);
            helper(root, destValue, endToRoot);

            int i = startToRoot.length(), j = endToRoot.length();
            int cnt = 0;
            while (i > 0 && j > 0 && startToRoot.charAt(i - 1) == endToRoot.charAt(j - 1)) {
                cnt++;
                i--;
                j--;
            }
            String sPath = "U".repeat(startToRoot.length() - cnt);
            String ePath = endToRoot.reverse().toString().substring(cnt, endToRoot.length());
            return sPath + ePath;
        }

        private boolean helper(TreeNode root, int val, StringBuffer stringBuffer) {
            if (root == null) return false;
            if (root.val == val) return true;
            if (helper(root.left, val, stringBuffer)) {
                stringBuffer.append("L");
            } else if (helper(root.right, val, stringBuffer)) {
                stringBuffer.append("R");
            }
            return stringBuffer.length() > 0;
        }

    }

    interface Test {
        String getDirections(TreeNode root, int startValue, int destValue);
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
