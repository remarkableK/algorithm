package com.zk.pdd;

import java.util.Scanner;

/**
 * 3
 * <p>
 * 5 3
 * 1 3 5
 * 1 3 1
 * <p>
 * 2 2
 * 1 2
 * 1 1
 * <p>
 * 12 3
 * 4 8 12
 * 3 3 3
 */
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        for (int i = 0; i < groups; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 0) {
                long res = 4;
                for (int j = 1; j < n; j++) {
                    res = res * 3 % 1000000007;
                }
                System.out.println(res);
            } else if (m == n) {
                System.out.println(0);
            } else {
                System.out.println(Math.pow(2,n-m)%1000000007);
            }
        }
    }
}
