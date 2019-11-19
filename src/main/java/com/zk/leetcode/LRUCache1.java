package com.zk.leetcode;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU
 *方式1 继承LinkedHashMap
 * @author 95620
 */
public class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        //第三个参数 按访问顺序排序，，还有就是按插入顺序跑徐
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    /**
     * 是否移除最久没有被访问的元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
