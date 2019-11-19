package com.zk.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长等差距离
 */
public class MaxDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(getMaxDis(nums));
    }

    public static int getMaxDis(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = nums.length;
        Arrays.sort(nums);

        if (nums[0] == nums[len - 1]) {
            return len;
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;
            }
        }


        int result = 2;
        for (int j = len - 2; j >= 1; j--) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k <= len - 1) {
                int left = nums[j] - nums[i];
                int right = nums[k] - nums[j];
                if (left < right) {
                    i--;
                } else if (left > right) {
                    k++;
                } else {
                    dp[i][j] = dp[j][k] +1;
                    result = Math.max(result,dp[i][j]);
                }
                i--;k++;
            }
        }
        return result;
    }
}
