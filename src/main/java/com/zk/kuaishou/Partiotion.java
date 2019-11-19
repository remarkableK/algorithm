package com.zk.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

public class Partiotion {
    public int canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
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
        return sum- 2*dp[values.length-1][sum / 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Partiotion canPartition = new Partiotion();
        System.out.println(canPartition.canPartition(nums));
    }

}
