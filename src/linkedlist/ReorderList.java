package linkedlist;

/**
 * https://oj.leetcode.com/problems/reorder-list/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        ListNode prev = slow.next;
        slow.next = null;
        ListNode cur = null;
        //reverse second half of the list
        while (prev != null) {
            ListNode next = prev.next;
            prev.next = cur;
            cur = prev;
            prev = next;
        }

        ListNode first = head;
        ListNode second = cur;
        while (first != null && second != null && first != second) {
            ListNode tmp = second.next;
            second.next = first.next;
            first.next = second;

            first = second.next;
            second = tmp;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
