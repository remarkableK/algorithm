package com.zk.dp;

import java.util.Arrays;

/**
 * leetcode416 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author 95620
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //和为奇数必不可能
        if ((sum & 1) == 1) {
            return false;
        }
        //转换为 01 背包，容量为 sum/2
        int[] values = new int[nums.length + 1];
        System.arraycopy(nums, 0, values, 1, nums.length);
        int[] weights = Arrays.copyOf(values, values.length);
        int[][] dp = new int[values.length + 1][1 + sum / 2];
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < 1 + sum / 2; j++) {
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[values.length][sum / 2] == sum / 2;
    }

    /**
     * 2
     * 4
     * 5 9 4 7
     * 8
     * 9 13 18 10 12 4 18 3
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(nums));
    }
    /**
     * 常规 0-1 背包问题的写法
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int size = nums.length;

        int s = 0;
        for (int num : nums) {
            s += num;
        }

        // 特判 2：如果是奇数，就不符合要求
        if ((s & 1) == 1) {
            return false;
        }

        int target = s / 2;

        // 创建二维状态数组，行：物品索引，列：容量
        boolean[][] dp = new boolean[size][target + 1];
        // 先写第 1 行
        for (int i = 1; i < target + 1; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[size - 1][target];
    }
}
