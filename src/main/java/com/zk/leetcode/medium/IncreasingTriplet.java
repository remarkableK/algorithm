package com.zk.leetcode.medium;

/**
 * 递增的三元子序列
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (first >nums[i]) {
                first = nums[i];
            } else if (nums[i] > first && nums[i] < second) {
                second = nums[i];
            } else if (nums[i] > second){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2,5,3,4,5};
        IncreasingTriplet in  = new IncreasingTriplet();
        System.out.println(in.increasingTriplet(array));
    }

}
