package leetcode.ph;

import leetcode.difficulty.Difficulty;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _559_MaximumDepthOf_N_ary_Tree {

    private final static LeetCode leetCode = new Solution();

    /**
     * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
     *
     * @see Difficulty#Easy()
     * @see Topic#Tree()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(Node root, int expected) {
        int actual = leetCode.maxDepth(root);
        Assert.assertEquals(expected, actual);
    }

    public static class Solution implements LeetCode {
        @Override
        public int maxDepth(Node root) {
            return 0;
        }
    }

    interface LeetCode {
        int maxDepth(Node root);
    }

    public static class Test1 implements LeetCode {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            if (root.children == null) return 1;
            Iterator<Node> iterator = root.children.iterator();
            int result = 1;
            while (iterator.hasNext()) {
                result = Math.max(result, maxDepth(iterator.next()) + 1);
            }
            return result;
        }
    }

    /**
     * 效能比Test1還要好
     */
    public static class Test2 implements LeetCode {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            if (root.children == null) return 1;
            Iterator<Node> iterator = root.children.iterator();
            int result = 0;
            while (iterator.hasNext()) {
                result = Math.max(result, maxDepth(iterator.next()));
            }
            return result + 1;
        }
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new Node(1,
                                Arrays.asList(
                                        new Node(3, Arrays.asList(new Node(5), new Node(6))),
                                        new Node(2),
                                        new Node(4))
                        ),
                        3
                ),
                arguments(new Node(1,
                                Arrays.asList(
                                        new Node(2),
                                        new Node(3, Arrays.asList(
                                                new Node(6),
                                                new Node(7, Arrays.asList(
                                                        new Node(11, Arrays.asList(
                                                                new Node(14)
                                                        ))
                                                )))
                                        ),
                                        new Node(4, Arrays.asList(
                                                new Node(8, Arrays.asList(new Node(12))))
                                        ),
                                        new Node(5, Arrays.asList(
                                                new Node(9, Arrays.asList(new Node(13))),
                                                new Node(10))
                                        )
                                )
                        ),
                        5
                )
        );
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
