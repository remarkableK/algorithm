package com.zk.dp;

/**
 * 最大子序列和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
                begin = i;
            } else {
                sum += nums[i];
            }
            if (sum > result) {
                end = i;
            }
            result = Math.max(result, sum);

        }
        System.out.println(begin + " " + end);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
