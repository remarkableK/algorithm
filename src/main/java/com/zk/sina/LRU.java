package com.zk.sina;

import java.util.HashMap;

/**
 * 实现LRU
 */
public class LRU {
    int capacity;
    int size;
    LinkedNode head = null;
    LinkedNode tail = null;
    HashMap<Integer, LinkedNode> map = null;


    class LinkedNode {
        int key;
        int val;
        LinkedNode pre;
        LinkedNode next;
    }
    /**
     * 新加结点永远在头部
     *
     * @param node
     */
    public void addNode(LinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    /**
     * 删除
     *
     * @param node
     */
    public void deleteNode(LinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    /**
     * 新访问移动到开头
     *
     * @param node
     */
    public void moveToHead(LinkedNode node) {
        deleteNode(node);
        addNode(node);
    }

    public LinkedNode popTail() {
        LinkedNode node = tail.pre;
        deleteNode(node);
        return node;
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedNode cur = map.get(key);
            moveToHead(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            moveToHead(node);
        } else {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.val = value;
            addNode(newNode);
            map.put(key,newNode);
            size++;
            if (size > capacity) {
                LinkedNode last = popTail();
                map.remove(last.key);
                size--;
            }
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }
}
