package com.zk.netease.p2019summer;

import java.util.Scanner;

public class DoubleGame {
    int minTimes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            DoubleGame doubleGame = new DoubleGame();
            doubleGame.dfs(a, b, p, q, 0);
            System.out.println(doubleGame.minTimes);
        }
    }

    private void dfs(int a, int b, int p, int q, int times) {
        if (a >= b) {
            minTimes = Math.min(minTimes, times);
            return;
        }
        if (times > minTimes) {
            return;
        }
        dfs(a + p, b, p, q, times + 1);
        dfs(a, b, p * q, q, times + 1);
    }
}
