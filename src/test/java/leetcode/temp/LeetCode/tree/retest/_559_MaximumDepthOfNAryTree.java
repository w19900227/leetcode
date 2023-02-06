package leetcode.temp.LeetCode.tree.retest;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class _559_MaximumDepthOfNAryTree {

    private int maxDepth = 0;

    @BeforeEach
    public void init() {
        maxDepth = 0;
    }

    @Test
    public void test1() {
        List<Node> node3 = Arrays.asList(new Node(5), new Node(6));
        List<Node> node2 = Arrays.asList(new Node(3, node3), new Node(2), new Node(4));
        Node node = new Node(1, node2);

        int treeNode = maxDepth(node);

        Assert.assertTrue(treeNode == 3);
    }


    public int maxDepth(Node root) {
        helper(root, 1);
        return maxDepth;
    }

    private void helper(Node root, int depth) {
        if (root == null) return;
        this.maxDepth = Math.max(maxDepth, depth);
        if (root.children != null) {
            for (Node children : root.children) {
                helper(children, depth + 1);
            }
        }
    }

    class Node {
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