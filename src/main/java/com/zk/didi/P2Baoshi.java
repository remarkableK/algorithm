package com.zk.didi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 5 10000 1000
 * 1 5 4 2 3
 * 5 4 3 2 1
 */
public class P2Baoshi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            arr2[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(n - dp[n][n]);
    }
}
