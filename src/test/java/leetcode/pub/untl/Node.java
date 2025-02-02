package leetcode.pub.untl;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public int getVal() {
        return val;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public static Node newNode() {
        return new Node();
    }

    public static Node newNode(int val) {
        return new Node(val);
    }

    public static Node newNode(int val, List<Node> neighbors) {
        return new Node(val, neighbors);
    }
}
