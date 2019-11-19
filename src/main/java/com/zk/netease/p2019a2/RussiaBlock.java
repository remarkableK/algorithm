package com.zk.netease.p2019a2;

import java.util.Scanner;

/**
 * 俄罗斯方块
 */
public class RussiaBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            input[i] = sc.nextInt();
            cols[input[i]-1]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n ; i++) {
            if (cols[i] < min){
                min = cols[i];
            }
        }
        System.out.println(min);
    }
}
