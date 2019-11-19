package com.zk.shopee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [编程题]Shopee的办公室（二）
 * https://www.nowcoder.com/test/question/a71f3bd890734201986cd1e171807d30?pid=17091533&tid=26514352
 */
public class ShopeeOffice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        long[][] roads = new long[row + 1][col + 1];
        int bossNum = sc.nextInt();
        for (int i = 0; i < bossNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            roads[x][y] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= row; i++) {
            if (roads[i][0] != Integer.MIN_VALUE) {
                roads[i][0] = 1;
            }
        }
        for (int i = 0; i <= col; i++) {
            if (roads[0][i] != Integer.MIN_VALUE) {
                roads[0][i] = 1;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (roads[i][j] != Integer.MIN_VALUE) {
                    long x = roads[i - 1][j] == Integer.MIN_VALUE ? 0 : roads[i - 1][j] ;
                    long y = roads[i][j - 1] == Integer.MIN_VALUE ? 0 : roads[i][j - 1];
                    roads[i][j] = x + y;
                }
            }
        }
        System.out.println(roads[row][col]);
    }
}
