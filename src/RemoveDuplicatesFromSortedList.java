/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p/>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && node.val == next.val) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }
}
