package com.zk.bytedance.summer;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = 0;
        int index = 0;
        int[] times = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int j = i - 1;
            while (j >= 0 && nums[j] < nums[i]) {
                j--;
            }
            if (j < 0) {
                continue;
            }
            times[j]++;
            if (times[j] > max) {
                max = times[j];
                index = j;
            }
        }
        if (max == 0) {
            System.out.println(0);
        } else {
            System.out.println(nums[index]);
        }
    }
}
