package com.zk.webank;

import java.util.Scanner;

/**
 * 阶乘最后一个为0的数字
 */
public class FirstZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long multi = 1;
        for (int i = 2; i <= n; i++) {
            multi = multi * i;
            if (multi % 10 == 0) {
                multi = multi / 10;
            }
            multi = multi % 1000000;
        }
        System.out.println(multi % 10);
    }
}
