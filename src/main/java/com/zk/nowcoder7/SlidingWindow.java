package com.zk.nowcoder7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * K大的滑动窗口的最大值
 * 链接：https://www.nowcoder.com/questionTerminal/1624bc35a45c42c0bc17d17fa0cba788
 * 来源：牛客网
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        SlidingWindow slidingWindow = new SlidingWindow();
        System.out.println(Arrays.toString(slidingWindow.solution(nums,3).toArray()));
    }

    public ArrayList<Integer> solution(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k ==0) {
            return result;
        }
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //过期
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //删除比新进小的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i + 1 >= k) {
                result.add(nums[deque.peekFirst()]);
            }
        }
        return result;
    }
}
