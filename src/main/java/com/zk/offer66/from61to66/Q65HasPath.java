package com.zk.offer66.from61to66;

import java.util.Arrays;

/**
 * 矩阵中的路径
 */
public class Q65HasPath {
    int[][] move = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    if (dfs(matrix, i, j, 0, str, visited, rows, cols)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     */
    public boolean dfs(char[] matrix, int x, int y, int step, char[] str, boolean[][] visited, int rows, int cols) {
        if (step == str.length) {
            return true;
        }
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
            return false;
        }
        boolean temp;
        if (!visited[x][y] && matrix[x * cols + y] == str[step]) {
            visited[x][y] = true;
            step++;
            temp = dfs(matrix, x + 1, y, step, str, visited, rows, cols) || dfs(matrix, x - 1, y, step, str, visited, rows, cols) ||
                    dfs(matrix, x, y + 1, step, str, visited, rows, cols) || dfs(matrix, x, y - 1, step, str, visited, rows, cols);
            if (temp) {
                return true;
            }
        }
        //回溯。每个格子可能会重复多次访问
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        String s = "abcesfcsadee";
        String str = "bcced";
        Q65HasPath q65 = new Q65HasPath();
        System.out.println(q65.hasPath2(s.toCharArray(), 3, 4, str.toCharArray()));
    }

    /**
     * 二刷
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean t = dfs(matrix, rows, cols, str, i, j, 0, visited);
                if (t) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[] matrix, int rows, int cols, char[] str, int row, int col, int index, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row * cols + col]) {
            return false;
        }
        if (index == str.length - 1 && str[index] == matrix[row * cols + col]) {
            return true;
        }
        if (index == str.length - 1) {
            return false;
        }
        if (str[index] == matrix[row * cols + col]) {
            visited[row * cols + col] = true;
            boolean temp;
            temp = dfs(matrix, rows, cols, str, row - 1, col, index + 1, visited) ||
                    dfs(matrix, rows, cols, str, row + 1, col, index + 1, visited) ||
                    dfs(matrix, rows, cols, str, row, col - 1, index + 1, visited) ||
                    dfs(matrix, rows, cols, str, row, col + 1, index + 1, visited);
            if (temp) {
                return true;
            }

        }
        visited[row * cols + col] = false;
        return false;
    }

}
