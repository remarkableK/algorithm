package com.zk.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 堆排序
 * @author 95620
 */
public class HeapSort {
    public int[] heapSort(int[] nums) {
        int len = nums.length;
        //建立大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            ajustHead(nums, i,len);
        }
        //循环的将堆的第一位与末尾交换，然后重新构造大顶堆
        while (len > 0) {
            SortUtil.swap(nums, 0, len - 1);
            len--;
            ajustHead(nums, 0,len);
        }
        return nums;
    }

    /**
     * 调成大顶堆
     * @param nums
     */
    public void ajustHead(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int maxIndex = left;
        //右子树大
        if (left + 1 < len && nums[left] < nums[left + 1]) {
            maxIndex = left + 1;
        }
        if (maxIndex < len && nums[i] < nums[maxIndex]) {
            SortUtil.swap(nums, i, maxIndex);
            //递归的调整子树！！！
            ajustHead(nums, maxIndex,len);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4, 1};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.heapSort(nums)));
        LinkedList<Character> queue = new LinkedList<>();

    }
}
