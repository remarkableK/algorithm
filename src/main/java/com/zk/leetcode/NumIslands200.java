package com.zk.leetcode;

import java.util.Arrays;

/**
 * 200题岛屿数量 标准dfs
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands200 {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        NumIslands200 nu = new NumIslands200();
        System.out.println(nu.numIslands(grid));

    }

    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(int x, int y, char[][] grid, boolean[][] visited) {
        int xx, yy;
        for (int i = 0; i < dir.length; i++) {
            xx = x + dir[i][0];
            yy = y + dir[i][1];
            //出界情况
            if (xx < 0 || xx >= grid.length || yy < 0 || yy >= grid[0].length) {
                continue;
            }
            if (grid[xx][yy] == '1' && !visited[xx][yy]) {
                visited[xx][yy] = true;
                dfs(xx, yy, grid, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return result;
    }


}
