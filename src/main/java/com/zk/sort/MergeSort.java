package com.zk.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public void mergeSort(int[] nums, int left, int right) {
        if (nums.length == 0 || left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    private void merge(int[] nums, int left, int middle, int right) {
        if (left == right) {
            return;
        }
        int[] temp = new int[nums.length];
        int i = middle, j = right;
        int index = right;
        while (i >= left && j > middle) {
            if (nums[i] <= nums[j]) {
                temp[index--] = nums[j--];
            } else {
                temp[index--] = nums[i--];
            }
        }
        for (; i >= left; i--) {
            temp[index--] = nums[i];
        }
        for (; j > middle; j--) {
            temp[index--] = nums[j];
        }
        for (int k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        MergeSort sort = new MergeSort();
        sort.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

//    /**
//     * 不复制，带指针的
//     */
//    public void mergeSort(int[] nums, int left, int right) {
//        if ((nums.length == 0) || (left >= right)) {
//            return;
//        }
//        int middle = (right - left) / 2 + left;
//        mergeSort(nums, left, middle);
//        mergeSort(nums, middle+1, right);
//        aux = new int[nums.length];
//        merge(nums, left, middle, right);
//    }
//
//    /**
//     * 合并
//     *
//     * @param leftArray
//     * @param left
//     * @param middle
//     * @param rightArray
//     * @return
//     */
//    private int[] aux;
//
//    private void merge(int[] nums, int left, int middle, int right) {
//        int i = left, j = middle + 1;
//
//        for (int k = left; k <= right; k++) {
//            // 将数据复制到辅助数组
//            aux[k] = nums[k];
//        }
//        for (int k = left; k <= right; k++) {
//            if (i > middle) {
//                nums[k] = aux[j++];
//
//            } else if (j > right) {
//                nums[k] = aux[i++];
//
//            } else if (aux[i] < aux[j]) {
//                // 先进行这一步，保证稳定性
//                nums[k] = aux[i++];
//            } else {
//                nums[k] = aux[j++];
//            }
//        }
//    }
}
