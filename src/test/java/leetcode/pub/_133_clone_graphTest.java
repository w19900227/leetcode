package leetcode.pub;

import leetcode.difficulty.Difficulty;
import leetcode.pub.untl.Node;
import leetcode.tag.Topic;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static leetcode.pub.untl.DeepCompare.areNodeEqual;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class _133_clone_graphTest {

    private static final LeetCode leetCode = new Solution1();

    public static class Solution implements LeetCode {
        @Override
        public Node cloneGraph(Node node) {
            return null;
        }
    }

    /**
     * https://leetcode.com/problems/clone-graph
     *
     * @see Difficulty#Easy()
     * @see Topic#HashTable()
     * @see Topic#DepthFirstSearch()
     * @see Topic#BreadthFirtstSearch()
     * @see Topic#Graph()
     */
    @ParameterizedTest
    @MethodSource("source")
    public void test(Node node, Node expected) {
        LeetCode leetCode = new Solution1();
        Node actual = leetCode.cloneGraph(node);
        Assert.assertTrue(areNodeEqual(expected, actual));
    }

    public static class Solution1 implements LeetCode {
        private Map<Node, Node> map = new HashMap<>();

        @Override
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            if (map.containsKey(node)) return map.get(node);
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            if (!node.neighbors.isEmpty()) {
                List<Node> newNeighborList = new ArrayList<Node>();
                for (Node neighborNode : node.neighbors) {
                    newNeighborList.add(cloneGraph(neighborNode));
                }
                newNode.neighbors = newNeighborList;
            }
            return newNode;
        }
    }

    public interface LeetCode {
        Node cloneGraph(Node node);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(Node.newNode(),
                        Node.newNode()
                ),
                arguments(null,
                        null
                )
        );
    }
}