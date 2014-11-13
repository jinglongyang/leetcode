package linkedlist;

/**
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p/>
 * return 1->4->3->2->5->NULL.
 * <p/>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n || n < 0 || m == n) return head;
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && index < m) {
            index++;
            node = node.next;
        }
        node.next = reverse(node.next, n - m);
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int n) {
        ListNode prev = null, node = head;
        int index = 0;
        while (node != null && index <= n) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            index++;
        }
        head.next = node;
        return prev;
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
