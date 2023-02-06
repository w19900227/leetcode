package leetcode.temp.LeetCode;

import org.junit.jupiter.api.Test;

class LeetCode {

    @Test
    public void test() {
//        ListNode listNode1 = mergeTwoLists(new ListNode(), new ListNode());
//        ListNode listNode2 = mergeTwoLists(new ListNode(), new ListNode(0, new ListNode(0)));
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = mergeTwoLists(l1, l2);
        System.out.println();
    }

    private ListNode temp;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            return null;
        }
        if (l1.next == null && l2 != null) {
            return l2;
        }
        if (l2.next == null && l1 != null) {
            return l1;
        }
        while (l1.val > l2.val) {
            l2.next = new ListNode(l1.val, l2.next);
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}