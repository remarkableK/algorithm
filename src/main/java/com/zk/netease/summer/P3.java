package com.zk.netease.summer;

import javax.print.attribute.standard.NumberUp;
import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        boolean existOdd = false;
        boolean existEven = false;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] % 2 == 0) {
                existEven = true;
            } else {
                existOdd = true;
            }
        }
        if (existEven && existOdd) {
            Arrays.sort(nums);
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[n - 1]);
    }
}
