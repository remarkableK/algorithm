package com.zk.baidu;


import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean[][] map = new boolean[n+1][n+1];
        for (int i = 0; i <=n ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int len = 0;
                if (map[i][j]) {
                    len = dfs(nums,i,j,len,map);
                }
                max = Math.max(max,len);
            }
        }
        System.out.println(max);
    }

    public static int dfs(int[] nums, int x, int oldx, int len, boolean[][] map) {
        if (x <= 0 || x >= nums.length) {
            return 0;
        }
        if (nums[x] <= nums[oldx]) {
            return 0;
        }
        len++;
        for (int i = 0; i < nums.length; i++) {
            if (map[x][i]) {
                len += dfs(nums, i, x, len, map);
            }
        }
        return len;
    }
}
