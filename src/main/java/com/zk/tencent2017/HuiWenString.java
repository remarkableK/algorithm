package com.zk.tencent2017;

import java.util.Scanner;

/**
 * 构造回文
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 */
public class HuiWenString {
    /**
     * /*
     * 解题思路：
     *   （1）把字符串旋转形成另外一个字符串，称为旋转字符串；
     *   （2）求原字符串s1与旋转字符串s2中，最长公共子串的长度；
     *   （3）删除的字符数目 = 原字符串的长度 - 最长公共子串的长度。
     * 需要解决的子问题：
     *    求两个字符串s1和s2中最长公共子串的长度。
     *    子问题的求解方式：动态规划
     *      设 MaxLen(i,j)表示s1左边i个字符与s2左边j个字符的最长公共子串长度，则子问题的解为MaxLen(strlen(s1),strlen(s2));
     *      MaxLen(i,j)的求解方式为：
     *        若s1第i个字符与s2第j个字符相匹配，则 return 1+MaxLen(i-1,j-1);
     *        否则：return max(MaxLen(i-1,j),MaxLen(i,j-1))
     *     边界条件：
     *     MaxLen(i,n)=0; for n in 0 to strlen(s2)
     *     MaxLen(n,j)=0; for n in 0 to strlen(s1)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = new StringBuilder(s1).reverse().toString();
            int[][] dp = new int[s1.length() + 1][s1.length() + 1];
            for (int i = 1; i <dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(s1.length() - dp[s1.length()][s2.length()]);
        }
    }
}
