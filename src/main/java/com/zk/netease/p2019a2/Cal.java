package com.zk.netease.p2019a2;

import java.util.Scanner;

/**
 * 表达式求值
 */
public class Cal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int num1 = a + b + c;
        int num2 = a + b * c;
        int num3 = a * b + c;
        int num4 = a * b * c;
        int num5 = (a + b) * c;
        int num6 = a * (b + c);
        Cal cal = new Cal();
        System.out.println(cal.getMax(num1, num2, num3, num4, num5, num6));
    }

    private int getMax(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
