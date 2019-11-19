package com.zk.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 递归版
     *
     * @param nums
     * @param left
     * @param right
     */
    public void sort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        if (i >= j) {
            return;
        }
        int flag = nums[left];
        while (i < j) {
            //从右往左找到第一个小于flag的 赋值给左指针
            while (i < j && nums[j] >= flag) {
                j--;
            }
            nums[i] = nums[j];
            //从左往右找到第一个大于flag的 赋值给右指针
            while (i < j && nums[i] <= flag) {
                i++;
            }
            nums[j] = nums[i];
        }
        //填空
        nums[i] = flag;
        sort(nums, left, i - 1);
        sort(nums, j + 1, right);
    }

    /**
     * 非递归
     *
     * @param nums
     * @return
     */
    public int[] quickSortNoRecusion(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            int i = left;
            int j = right;
            if (i >= j) {
                continue;
            }
            int flag = nums[left];
            while (i < j) {
                //从右往左找到第一个小于flag的 赋值给左指针
                while (i < j && nums[j] >= flag) {
                    j--;
                }
                nums[i] = nums[j];
                //从左往右找到第一个大于flag的 赋值给右指针
                while (i < j && nums[i] <= flag) {
                    i++;
                }
                nums[j] = nums[i];
            }
            //填空
            nums[i] = flag;
            stack.push(right);
            stack.push(j + 1);
            stack.push(i - 1);
            stack.push(left);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 2, 4, 1};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSortNoRecusion(nums)));
    }
}
