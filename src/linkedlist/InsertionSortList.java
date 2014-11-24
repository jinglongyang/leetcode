package linkedlist;

/**
 * https://oj.leetcode.com/problems/insertion-sort-list/
 * <p/>
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        System.out.println(new InsertionSortList().insertionSortList(head));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            insertNode(dummy, node);
            node = next;
        }
        return dummy.next;
    }

    private void insertNode(ListNode head, ListNode node) {
        ListNode prev = head, temp = head.next;
        while (temp != null && node.val > temp.val) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = node;
        node.next = temp;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
