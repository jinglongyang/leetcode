package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
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

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        Queue<List<ListNode>> queue = new LinkedList<>();
        queue.offer(lists);
        while (queue.peek().size() > 1) {
            List<ListNode> tmp = queue.poll();
            List<ListNode> newNodes = new ArrayList<>(tmp.size());
            for (int i = 0; i < tmp.size(); i += 2) {
                newNodes.add(merge(tmp.get(i), i + 1 >= tmp.size() ? null : tmp.get(i + 1)));
            }
            queue.offer(newNodes);
        }
        return queue.poll().get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0), current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }
}
