package com.zk.leetcode.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口的最大值
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //判断头部是否过期
            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.pollFirst();
            }
            //从队尾开始，比当前值小的都出队
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            //添加当前结点队
            deque.addLast(i);
            //获取当前窗口的最大值
            if (i + 1 >= k) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
