package com.zk.dp;

/**
 * 完全背包
 */
public class FullPackage {
    public static void main(String[] args) {

    }

    // 完全背包：一维法
    public static int bag3(int capacity, int[] w, int[] v) {
        // 第一个值，不算
        //dp[i] 表示背包容量为i是的最大值
        int[] dp = new int[capacity + 1];
        int n = w.length - 1;
        //对于n个物品,一次遍历所有的物品，和01背包一样
        for (int i = 1; i <= n; i++) {
            //遍历每个重量
            for (int j = w[i]; j <= capacity; j++) {
                //放入比较大
                if (dp[j - w[i]] + v[i] > dp[j]) {
                    dp[j] = dp[j - w[i]] + v[i];
                }
            }
        }
        // 最优解
        return dp[capacity];
    }
}
