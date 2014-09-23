/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p/>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
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
        if (head == null) return head;
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        while (head != null) {
            ListNode next = head.next;
            if (next == null || next.val != head.val) {
                pre.next = head;
                pre = head;
            } else {
                while (next != null && next.val == head.val) {
                    next = next.next;
                }
                pre.next = next;
            }
            head = next;
        }
        return dummyNode.next;
    }
}
