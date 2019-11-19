package com.zk.netease.test;

/**
 *用1*3的瓷砖密铺3*20的地板有几种方式？
 */
public class Floor {
    public static void main(String[] args) {
        int n = 20;
        int[] dp = new int[21];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        System.out.println(dp[20]);
    }
}
