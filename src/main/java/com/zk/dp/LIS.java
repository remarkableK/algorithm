package com.zk.dp;

import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class LIS {

    private static int solution(int[] nums) {
        //dp[i] 表示截止到i最长的递增子序列长度是多少
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 5, 9, 4, 8};
        System.out.println(solution(nums));
    }
}
