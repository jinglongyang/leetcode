package linkedlist;

/**
 * https://oj.leetcode.com/problems/rotate-list/
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new RotateList().rotateRight(head, 2));
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 1 || head.next == null) return head;
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        node.next = head;
        int k = len - n % len;
        int step = 0;
        while (step < k) {
            step++;
            node = node.next;
        }

        ListNode res = node.next;
        node.next = null;
        return res;
    }

    private ListNode getRunner(ListNode head, int n) {
        ListNode fast = head;
        int index = 0;
        while (fast != null && index < n) {
            index++;
            fast = fast.next;
        }
        return fast;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + (next == null ? "" : "," + next.toString());
        }
    }
}
