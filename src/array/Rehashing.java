package array;

/**
 * Created by jinglongyang on 1/11/15.
 */
public class Rehashing {
    public static void main(String[] args) {
        ListNode head = new ListNode(29);
        head.next = new ListNode(5);
        System.out.println(new Rehashing().rehashing(new ListNode[]{null, null, head}));
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int len = hashTable == null ? 0 : hashTable.length;

        if (len == 0) {
            return hashTable;
        }
        len *= 2;
        ListNode[] res = new ListNode[len];
        for (ListNode node : hashTable) {
            while (node != null) {
                int idx = node.val % len;
                if (idx < 0) {
                    idx = (idx + len) % len;
                }
                ListNode tail;
                if (res[idx] == null) {
                    res[idx] = node;
                    tail = res[idx];
                } else {
                    tail = res[idx];
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = node;
                    tail = tail.next;
                }
                node = node.next;
                tail.next = null;
            }
        }
        return res;
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
