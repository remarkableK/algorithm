package com.zk.netease.p2019summer;

import java.util.Scanner;

/**
 * 最小数位和
 */
public class MinNunberSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x <= 9) {
                System.out.println(x);
            } else {
                StringBuilder sb = new StringBuilder();
                while (x > 9) {
                    sb.append(9);
                    x = x - 9;
                }
                sb.append(x);
                System.out.println(sb.reverse().toString());
            }
        }
    }
}
