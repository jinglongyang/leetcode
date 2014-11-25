package map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/lru-cache/
 * <p/>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LruCache2 {
    private int capacity;
    private Map<Integer, Node> cache;
    private int size = 0;
    private LinkedList list;

    public LruCache2(int capacity) {
        this.capacity = capacity;
        if (capacity < 1) {
            throw new IllegalArgumentException("");
        }
        cache = new HashMap<>();
        list = new LinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        list.promote(node);
        return node.value;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            list.promote(node);
        } else {
            if (capacity > size) {
                size++;
            } else {
                cache.remove(list.removeFirst().key);
            }
            Node node = new Node(key, value);
            list.addLast(node);
            cache.put(key, node);
        }
    }


    private static class LinkedList {
        private Node head, tail;

        private LinkedList() {
            //dummy head and tail
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        private Node removeFirst() {
            Node first = head.next;

            head.next = first.next;
            first.next.prev = head;

            first.next = null;
            first.prev = null;
            return first;
        }

        private void addLast(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        /**
         * move node to tail
         *
         * @param node
         */
        private void promote(Node node) {
            Node prev = tail.prev;
            if (prev != node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                addLast(node);
            }
        }
    }

    private static class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
