package com.zk.leetcode.threads;

        import java.util.*;

/**
 * LRU2
 * 双向链表 + 哈希表
 */
public class LRUCache2 {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
    }

    /**
     * 新增一个结点，永远加在头结点的后面
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    /**
     * 从当前的链表中删除一个结点
     *
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 当一个结点重新访问过，将当前结点放到head后面
     *
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode t = tail.pre;
        removeNode(t);
        return t;
    }

    /**
     * map用于获取
     */
    HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    /**
     * 用于维护一个双向链表，从头到尾依次为最近访问的结点
     */
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            cache.put(key,node);
            moveToHead(node);
        } else {
            //如果不存在结点
            node = new DLinkedNode();
            node.val = value;
            node.key = key;
            addNode(node);
            cache.put(key,node);
            size++;
            if (size > capacity) {
                //超出缓存页框大小，移除掉
                DLinkedNode last = popTail();
                cache.remove(last.key);
                removeNode(last);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1,1);
        lruCache2.put(2,2);
        System.out.println(lruCache2.get(1));
    }
}
