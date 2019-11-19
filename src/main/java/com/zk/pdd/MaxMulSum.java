package com.zk.pdd;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 最大乘积和
 */
public class MaxMulSum {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        PriorityQueue<Integer> queue = new PriorityQueue<>(m * 2);
//        for (int i = 0; i < n; i++) {
//            queue.add(sc.nextInt());
//        }
//        Integer[] array = null;
//        if (queue.size() >= m * 2) {
//            array = Arrays.copyOf(queue.toArray(new Integer[queue.size()]), m * 2);
//        }else {
//            array = queue.toArray(new Integer[queue.size()]);
//        }
//        long sum = 0;
//        int beginIdx = 0;
//        int endIdx = array.length - 1;
//        for (int i = 0; i < m; i++) {
//            if (beginIdx < endIdx) {
//                sum += (array[beginIdx] * array[endIdx]);
//                beginIdx++;
//                endIdx--;
//            }else {
//                break;
//            }
//        }
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        long sum = 0;
        int beginIdx = 0;
        int endIdx = 2 * m - 1;
        for (int i = 0; i < m; i++) {
            if (beginIdx <= endIdx) {
                sum += (nums[beginIdx] * nums[endIdx]);
                beginIdx++;
                endIdx--;
            } else {
                break;
            }
        }
        System.out.println(sum);
    }

}
