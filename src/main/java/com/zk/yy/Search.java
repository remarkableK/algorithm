package com.zk.yy;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length - 1];
        for (int i = 0; i < strs.length - 1; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int target = Integer.parseInt(strs[strs.length - 1]);
        //二分
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                if (middle == nums.length - 1 || nums[middle] != nums[middle + 1]) {
                    System.out.println(middle);
                    return;
                } else {
                    while (middle + 1 < nums.length && nums[middle] == nums[middle + 1]) {
                        middle++;
                    }
                    if (middle+1 == nums.length-1 && nums[middle] == nums[middle + 1]){
                        System.out.println(middle+1);
                    }else {
                        System.out.println(middle);
                    }
                    return;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

    }
}
