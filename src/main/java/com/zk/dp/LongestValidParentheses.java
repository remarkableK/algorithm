package com.zk.dp;

import java.util.Stack;

/**
 * 最长有效括号
 */
public class LongestValidParentheses {
    /**
     * 暴力超时 截取所有的偶数对字符串 用栈来验证是否是格式正确的
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j <= len; j = j + 2) {
                if (isValid(s, i, j)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    /**
     * 验证从i 到 j-1是否是格式正确的
     */
    private boolean isValid(String s, int i, int j) {
        String temp = s.substring(i, j);
        Stack<Character> stack = new Stack<>();
        for (int k = 0; k < temp.length(); k++) {
            if (temp.charAt(k) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(new LongestValidParentheses().dpSolution(s));
    }

    /**
     * dp
     * 记dp[i] 为 截止到当前元素i 有效的最长括号对长度
     * 每次成对扫描两个元素 如果是 （）  dp[i] = d[i-2]+2;
     * 如果是))  就检查 如果s[i - dp[i-1] -1] == '(' 那么 dp[i] = dp[i-1] + 2
     * 此外还要加上s[i - dp[i-1] -1]  之前的dp值dp[i-dp[i-1]-2]，因为可能会构成新的序列
     */
    public int dpSolution(String s) {
        int len = s.length();
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //如果是))
                    dp[i] = dp[i - 1] + 2;
                    //加上前面的s[i - dp[i-1] -1]的长度 ，因为构成了新的最长有效
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
