package com.zk.offer66.others;

/**
 * 收到礼物的最大值
 */
public class MaxGiftValue {
    /**
     * 二维数组DP
     *
     * @param gifts
     * @return
     */
    public int solution(int[][] gifts) {
        int row = gifts.length;
        int col = gifts[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0, left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + gifts[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 使用一维数组保存，详见剑指offer47
     * dp
     * @param gifts
     * @return
     */
    public int solution2(int[][] gifts) {
        int row = gifts.length;
        int col = gifts[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[j];
                }
                if (j > 0) {
                    left = dp[j - 1];
                }
                dp[j] = Math.max(up, left) + gifts[i][j];
            }
        }
        return dp[col-1];
    }

}
