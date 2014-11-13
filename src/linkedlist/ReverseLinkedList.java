package linkedlist;

/**
 * http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html
 * Implement the reversal of a singly linked list iteratively and recursively.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(head.toString());

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(reverseLinkedList.reverse(head));
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null, node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

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

        @Override
        public String toString() {
            return String.valueOf(val) + (next == null ? "" : "," + next.toString());
        }
    }
}
