package com.zk.east;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Main2 main2 = new Main2();
        System.out.println(main2.solution(nums));
    }

    public int solution(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i-1]) {
                max = nums[i];
            } else if (nums[i] <= nums[i-1]) {
                sum += (max - min);
                min = nums[i];
                max = nums[i];
            }
        }
        return sum;
    }
}
