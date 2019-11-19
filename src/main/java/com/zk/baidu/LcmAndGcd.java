package com.zk.baidu;

import java.util.Scanner;

public class LcmAndGcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long begin =System.currentTimeMillis();
        int n = sc.nextInt();
        long max = 0;
        for (int i = n; i > 1; i--) {
            for (int j = i - 1; j >= 1; j--) {
                if (System.currentTimeMillis() - begin >= 2000){
                    System.out.println(max);
                    return;
                }
                int gcd = gcd(i,j);
                long lcm = lcm(i,j,gcd);
                if (lcm - gcd >max){
                    max = lcm - gcd;
                }
            }
        }
        System.out.println(max);
    }

    /**
     * 最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int gcd = m % n;
            m = n;
            n = gcd;
        }
        return n;
    }

    /**
     * 最小公倍数
     *
     * @param m
     * @param n
     * @param gcd
     * @return
     */
    public static long lcm(int m, int n, int gcd) {
        return m * n / gcd;
    }
}
