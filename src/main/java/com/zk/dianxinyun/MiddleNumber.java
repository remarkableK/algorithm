package com.zk.dianxinyun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求中位数
 */
public class MiddleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        if (nums.length % 2 != 0) {
            System.out.println(nums[nums.length / 2]);
        } else {
            System.out.println(nums[nums.length / 2 - 1]);
        }
    }
}
