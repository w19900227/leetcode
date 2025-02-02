package leetcode.pub.untl;

import java.util.List;

public class DeepCompare {

    public static boolean areListEqual(List<Integer> l1, List<Integer> l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }

    public static boolean areListListEqual(List<List<Integer>> l1, List<List<Integer>> l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!areListEqual(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }

    public static boolean areNodeEqual(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true; // 兩個都是空
        if (n1 == null || n2 == null) return false; // 只有一個是空
        if (n1.getVal() != n2.getVal()) return false; // 節點值不同
        if (n1.getNeighbors().size() != n2.getNeighbors().size()) return false;
        for (int i = 0; i < n1.getNeighbors().size(); i++) {
            if (!areNodeEqual(n1.getNeighbors().get(i), n2.getNeighbors().get(i))) return false;
        }
        return true;
    }

    public static boolean areTreesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // 兩個都是空
        if (t1 == null || t2 == null) return false; // 只有一個是空
        if (t1.getVal() != t2.getVal()) return false; // 節點值不同

        // 遞迴比較左子樹和右子樹
        return areTreesEqual(t1.getLeft(), t2.getLeft()) && areTreesEqual(t1.getRight(), t2.getRight());
    }

}
