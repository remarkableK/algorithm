package com.zk.leetcode.medium;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    /**
     * dp
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            //在上一个子串中是否包含该数字
            int cIndex = contains(s, i - dp[i - 1], i, s.charAt(i));
            if (cIndex != -1) {
                //包含当前字符
                dp[i] = cIndex == i - 1 ? 1 : i - cIndex;
            } else {
                //不包括当前字符
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int contains(String s, int left, int right, char c) {
        for (int i = right - 1; i >= left; i--) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "anviaj";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(s));
    }

}
