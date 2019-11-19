package com.zk.dp;

/**
 * 01背包问题
 * 价值数组v = {8, 10, 6, 3, 7, 2}，
 * <p>
 * 重量数组w = {4, 6, 2, 2, 5, 1}，
 * 背包容量 12
 *
 * @author 95620
 */
public class ZeroOnePackage {
    /**
     * 空间复杂度n^2
     */
    public int solution(int[] values, int[] weights, int capacity) {
        //dp[i][j] 面对第i个物品，背包剩余容量为j时的值
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weights[i]) {
                    //不装和装入 哪个个更大就去哪个
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length - 1][capacity];
    }
    public static void main(String[] args) {
        int[] values = {0, 8, 10, 6, 3, 7, 2};
        int[] weights = {0, 4, 6, 2, 2, 5, 1};
        int capacity = 12;
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        System.out.println(zeroOnePackage.solution(values, weights, capacity));
    }
}
