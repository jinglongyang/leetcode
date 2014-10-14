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
public class LRUCache {
    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        private Node(Node prev, int key, int value) {
            this.prev = prev;
            if (prev != null)
                prev.next = this;
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;
    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(2 * capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            adjust(node);
            return node.value;
        }
        return -1;
    }

    private void adjust(Node node) {
        if (node != tail) {
            Node prev = node.prev;
            if (prev != null) {
                prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = prev;
                }
            } else {
                //head
                head = node.next;
                if (head != null) {
                    head.prev = null;
                }
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            adjust(node);
        } else {
            if (size == capacity) {
                cache.remove(head.key);
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else {
                size++;
            }
            Node node = new Node(tail, key, value);
            cache.put(key, node);
            tail = node;
            if (head == null) {
                head = node;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
