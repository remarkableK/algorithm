package com.zk.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public int[] selectedSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            SortUtil.swap(nums, i, index);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4, 1};
        SelectSort select = new SelectSort();
        System.out.println(Arrays.toString(select.selectedSort(nums)));
    }
}
