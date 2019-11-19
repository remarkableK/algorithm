package com.zk.offer66.from51to60;

import java.util.Arrays;

public class Q52Match {
    /**
     * 暴力递归
     * 回溯
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            sb2.append(pattern[i]);
        }
        return dp(sb.toString(), sb2.toString());
    }

    public boolean dp(String str, String pattern) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        boolean firstMatch = (!str.isEmpty())&& (str.charAt(0) == pattern.charAt(0)|| pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return dp(str,pattern.substring(2))||(firstMatch &&dp(str.substring(1),pattern));
        } else {
            return firstMatch && dp(str.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        Q52Match q52Match = new Q52Match();
        System.out.println(q52Match.dp("","."));
    }
}
