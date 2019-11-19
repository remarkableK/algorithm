package com.zk.dianxinyun;

import java.util.Scanner;

public class MaxSummer {

    /**
     * 最大子序列和
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > result) {
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1,s.length()-1);
        String[] strs = s.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i].trim());
        }
        MaxSummer maxSubArray = new MaxSummer();
        System.out.println(maxSubArray.maxSubArray(nums));
    }


}
