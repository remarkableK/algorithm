package com.zk.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
     */
    public int[] bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            boolean swap = false;
            for (int j = 1; j <= i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap = true;
                    SortUtil.swap(nums, j, j - 1);
                }
            }
            if (!swap) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(nums)));
    }
}
