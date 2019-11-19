package com.zk.bytedance.summer;

import java.util.Scanner;

public class Water {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        if (x == k || y == k || z == k) {
            System.out.println(1);
            return;
        }
        // System.out.println(6);          30%


    }

    private void dfs(int a, int b, int c, int x, int y, int z, int k, int times) {
        if (a == k || b == k || c == k) {
            min = Math.min(min, times);
            return;
        }
        //两个满了则退出
        if ((a == x && b == y) || (a == x && c == z) || (b == y && c == z)) {
            return;
        }
        //a->b
        if (a < b) {

        } else {

        }

    }
}
