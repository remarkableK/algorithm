package com.zk.pdd;

import java.util.Scanner;

public class Dic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        dfs(n, m, k, 0, 0, "");
    }

    static long count = -1;
    static boolean suc = false;

    private static void dfs(int n, int m, int k, int timesA, int timesB, String cur) {
        count++;
        if (count == k) {
            System.out.println(cur);
            suc = true;
            return;
        }
        if (timesA < n) {
            dfs(n, m, k, timesA + 1, timesB, cur + "a");
            if (suc) {
                return;
            }
        }
        if (timesB < m) {
            dfs(n, m, k, timesA, timesB + 1, cur + "b");
            if (suc) {
                return;
            }
        }
    }
}
