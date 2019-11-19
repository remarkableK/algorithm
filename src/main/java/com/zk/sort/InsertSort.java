package com.zk.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public int[] insertSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4, 1};
        InsertSort select = new InsertSort();
        System.out.println(Arrays.toString(select.insertSort1(nums)));
    }
}
