package com.zk.duxiaoman;

import java.util.Scanner;

public class Solution1 {
    int xMin = 0;
    int xMax = 0;
    int yMin = 0;
    int yMax = 0;

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Scanner sc = new Scanner(System.in);
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();
        solution1.xMax = Math.max(targetX, solution1.xMax);
        solution1.xMin = Math.min(targetX, solution1.xMin);
        solution1.yMax = Math.max(targetY, solution1.yMax);
        solution1.yMin = Math.min(targetY, solution1.yMin);
        //障碍数目
        int zNum = sc.nextInt();
        int[] zIndex = new int[zNum * 2];
        int index = 0;
        for (int i = 0; i < zNum * 2; i++) {
            zIndex[index] = sc.nextInt();
            if (i % 2 == 0) {
                solution1.xMax = Math.max(zIndex[index], solution1.xMax);
                solution1.xMin = Math.min(zIndex[index], solution1.xMin);
            } else {
                solution1.yMax = Math.max(zIndex[index], solution1.yMax);
                solution1.yMin = Math.min(zIndex[index], solution1.yMin);
            }
            index++;
        }
        solution1.xMin--;
        solution1.xMax++;
        solution1.yMin--;
        solution1.yMax++;
        int rows = solution1.xMax - solution1.xMin;
        int cols = solution1.yMax - solution1.yMin;

        int xOffset = -1 * solution1.xMin;
        int yOffset = -1 * solution1.yMin;
        int[][] maps = new int[rows+1][cols+1];
        boolean[][] visited = new boolean[rows+1][cols+1];
        for (int i = 0; i < zNum * 2; i = i + 2) {
            int x = zIndex[i];
            int y = zIndex[i + 1];
            maps[x + xOffset][y + yOffset] = -1;
        }
        solution1.dfs(maps, visited, xOffset, yOffset, rows, cols, targetX + xOffset, targetY + xOffset, 0);
        System.out.println(solution1.minSteps);
    }

    int minSteps = Integer.MAX_VALUE;
    private void dfs(int[][] maps, boolean[][] visited, int x, int y, int rows, int cols, int targetX, int targetY, int steps) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return;
        }
        if (maps[x][y] == -1 || visited[x][y]) {
            return;
        }
        if (x == targetX && y == targetY) {
            minSteps = Math.min(minSteps, steps+1);
            return;
        }
        visited[x][y] = true;
        dfs(maps, visited, x - 1, y, rows, cols, targetX, targetY, steps + 1);
        dfs(maps, visited, x + 1, y, rows, cols, targetX, targetY, steps + 1);
        dfs(maps, visited, x, y - 1, rows, cols, targetX, targetY, steps + 1);
        dfs(maps, visited, x, y + 1, rows, cols, targetX, targetY, steps + 1);
        visited[x][y] = false;
    }
}
