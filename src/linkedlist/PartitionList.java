package linkedlist;

/**
 * https://oj.leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
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

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode right = new ListNode(0);
        ListNode left = new ListNode(0);
        ListNode leftPref = left, rightPref = right;
        ListNode node = head;
        while (node != null) {
            if (node.val >= x) {
                rightPref.next = node;
                rightPref = node;
            } else {
                leftPref.next = node;
                leftPref = node;
            }
            node = node.next;
        }
        rightPref.next = null;
        leftPref.next = right.next;
        return left.next;
    }
}
