package com.zk.baidu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Recovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        long max = 0;
        long secondMax = -1;
        long index = -1;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            } else if (nums[i] <= max &&nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        long times = 0;
        times = (max - n)/n +1;

//        while (max >= n) {
//            nums[index] -= n;
//            max = nums[index];
//            long cIndex = index;
//            for (int i = 0; i < n; i++) {
//                if (i != cIndex) {
//                    nums[i]++;
//                }
//                if (nums[i] > max) {
//                    max = nums[i];
//                    index = i;
//                }
//            }
//            times++;
//        }
        System.out.println(times);
    }
}
