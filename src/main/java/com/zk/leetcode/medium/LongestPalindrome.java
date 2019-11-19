package com.zk.leetcode.medium;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    /**
     * 使用dp
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2 || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
            return s;
        }
        int len = s.length();
        int left = 0, right = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    left = i;
                    right = i + 1;
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j || j == i + 1) {
                    continue;
                }
                boolean eq = s.charAt(i) == s.charAt(j);
                dp[i][j] = dp[i + 1][j - 1] && eq;
                if (dp[i][j] && j - i > (right - left)) {
                    right = j;
                    left = i;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.solution2(s));
    }

    /**
     * 使用扫描
     */
    public String solution2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int l1 = getMaxLength(s, i, i);
            int l2 = getMaxLength(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getMaxLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
