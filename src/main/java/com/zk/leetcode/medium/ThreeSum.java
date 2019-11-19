package com.zk.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //先做一次排序
        Arrays.sort(nums);
        //正数是没必要的
        for (int i = 0; i < nums.length && nums[i] < 1; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] > 0) {
                continue;
            }
            //双指针 查找
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                //
                if (nums[left] + nums[right] == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去掉重复的
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, -1, 0, 1, 2};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(Arrays.toString(threeSum.threeSum(a).toArray()));
    }
}
