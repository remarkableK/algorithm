package com.zk.offer66.from11to20;

import com.zk.offer66.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q19_PrintMatrix {
    /**
     * 写的也太烂了，就是绕一圈，设置一个visited数组，其实觉得没必要，懒得改了
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null){
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] visited = new int[row][col];
        int i = 0 , j = 0;
        while (i<row && j < col && visited[i][j]!=1){
            //从左到右
            while (j < col && visited[i][j]!=1){
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                j++;
            }
            j--;i++;
            //从下到上
            while (i < row&& visited[i][j]!=1){
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                i++;
            }
            i--;j--;
            //从右到左
            while (j>=0&& visited[i][j]!=1){
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                j--;
            }
            j++;i--;
            //从下到上
            while (i>=0&&visited[i][j]!=1){
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                i--;
            }
            i++;j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };
        List<Integer> result = Q19_PrintMatrix.printMatrix(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
