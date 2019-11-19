package com.zk.yy;

import com.zk.huawei.summer.P1;

import java.util.Scanner;

public class PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = 0;
        int[][] map = new int[m][m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            if (n == 0) {
                n = strs.length;
                map = new int[m][n];
            }
            for (int j = 0; j < strs.length; j++) {
                map[index][j] = Integer.parseInt(strs[j]);
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            sb.append(map[r][c]);
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
