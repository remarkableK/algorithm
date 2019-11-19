package com.zk.trie;

import lombok.Data;
/**
 * @author 95620
 * 字典树
 */
public class Trie {

    private static final int SIZE = 26;
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 结点
     */
    @Data
    private class TrieNode {
        /**
         * 当前结点值
         */
        private char val;

        /**
         * 出现次数
         */
        private int times;
        /**
         * 根节点
         */
        private TrieNode[] son;
        private boolean isEnd;
        private boolean hasSon;

        TrieNode() {
            times = 1;
            son = new TrieNode[26];
            isEnd = true;
            hasSon = false;
        }
    }

    /**
     * 插入新单词
     *
     * @param str
     */
    public void insert(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            if (node.son[pos] == null) {
                node.hasSon = true;
                node.son[pos] = new TrieNode();
                node.son[pos].val = chars[i];
            } else {
                node.son[pos].times++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /**
     * 统计前缀出现次数
     *
     * @param str
     * @return
     */
    public int countPrefix(String prefixStr) {
        if (prefixStr == null || prefixStr.length() == 0) {
            return -1;
        }
        TrieNode node = root;
        char[] chars = prefixStr.toCharArray();
        for (char c :
                chars) {
            int pos = c - 'a';
            if (node.son[pos] == null) {
                return 0;
            } else {
                node = node.son[pos];
            }
        }
        return node.times;
    }

    /**
     * 删除
     *
     * @param str
     */
    public void delete(String str) {

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("abc");
        trie.insert("aa");
        trie.insert("ba");
        trie.insert("bac");
        System.out.println(trie.countPrefix("ab"));
    }
}
