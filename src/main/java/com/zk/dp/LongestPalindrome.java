package com.zk.dp;

/**
 * 最长回文子序列
 */
public class LongestPalindrome {
    /**
     * 暴力法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        String temp = s.charAt(0) + "";
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            //aba
            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                int left = i - 1, right = i + 1;
                while (left >= 0 && right < len) {
                    if (s.charAt(left) == s.charAt(right)) {
                        --left;
                        ++right;
                    } else {
                        break;
                    }
                }
                String current = s.substring(left + 1, right);
                if (current.length() > temp.length()) {
                    temp = current;
                }
            }
            //aa
            if (s.charAt(i) == s.charAt(i + 1)) {
                int left = i, right = i + 1;
                while (left >= 0 && right < len) {
                    if (s.charAt(left) == s.charAt(right)) {
                        --left;
                        ++right;
                    } else {
                        break;
                    }
                }
                String current = s.substring(left + 1, right);
                if (current.length() > temp.length()) {
                    temp = current;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(LongestPalindrome.longestPalindromeDp(s));
    }

    /**
     * dpa
     * https://leetcode-cn.com/articles/longest-palindromic-substring/
     */
    public static String longestPalindromeDp(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //初始化斜对角
        //状态转移方程 dp[i][j] = dp[i-1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            //初始化对角的右边
            if (i + 1 < len) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        //要倒着求 ，上三角
        int left = 0, right = 0;
        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                boolean eq = s.charAt(i) == s.charAt(j);
                if (i == j) {
                    continue;
                } else if (j == i + 1) {
                    dp[i][j] = eq;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && eq;
                }
                if (dp[i][j] && j-i >= right-left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
