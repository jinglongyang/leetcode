package linkedlist;

/**
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * <p/>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p/>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new ReverseNodesKGroup().reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        if (len < k) return head;
        int times = len / k;
        node = head;
        ListNode res = null, end = null;
        while (times > 0) {
            ListNode prev = null, start = node;
            int step = 0;
            while (step < k) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
                step++;
            }
            if (res == null) {
                res = prev;
            }
            if (end != null) {
                end.next = prev;
            }
            end = start;
            times--;
            if (times == 0) {
                end.next = node;
            }
        }
        return res;
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
