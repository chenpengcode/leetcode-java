package main.java.easy.design.p146;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/27
 */
public class LRUCache {
    static class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;

        DLinkedNode() {
        }

        DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size = 0;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            ++size;
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail);
                -- size;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
