package com.zk.netease.p2019summer;

import java.util.Scanner;

public class PerfectSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            int result = 0;
            int curSum = 0;
            int curLen = 0;
            for (int j = 0; j < len; j++) {
                nums[j] = sc.nextInt();
                if (nums[j] >= curSum) {
                    curSum += nums[j];
                    curLen++;
                    result = Math.max(result, curLen);
                } else {
                    curSum = nums[j];
                    curLen = 1;
                }
            }
            System.out.println(result);
        }
    }
}
