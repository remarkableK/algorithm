package com.zk.offer66.from31to40;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class Q34FirstNotRepeatingChar {
    /**
     * 最笨的方法，用hashmap暴力求解,时间复杂度O(n)，空间复杂度很更高
     *
     * @param str
     * @return
     */
    public int solution(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>(str.length() / 2);
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 第二种解法双指针，一个从左搜一个从右搜，如果相遇了则是没有
     * 还可以解除String的indexOf和lastIndexOf来求解更加的快速
     *
     * @param str
     * @return
     */
    public int solution2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int firstIndex = str.indexOf(c + "");
            int lastIndex = str.lastIndexOf(c + "");
            if (firstIndex == lastIndex) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从leetcode上看到的 不考虑其他，直接遍历a-z 和A-Z取其中所有最小的
     * @param str
     * @return
     */
    public int solution3(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int minIndex =Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int left = str.indexOf(i);
            int right = str.lastIndexOf(i);
            if (left != -1 && left == right && left < minIndex) {
                minIndex = left;
            }
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            int left = str.indexOf(i);
            int right = str.lastIndexOf(i);
            if (left != -1 && left == right && left < minIndex) {
                minIndex = left;
            }
        }
        //防止为找到
        return minIndex ==Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static void main(String[] args) {
        String s1 = "google";
        Q34FirstNotRepeatingChar q34 = new Q34FirstNotRepeatingChar();
        System.out.println(q34.solution3(s1));
    }
}
