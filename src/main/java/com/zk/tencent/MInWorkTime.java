package com.zk.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 3
 * 1 8
 * 2 5
 * 1 2
 */
public class MInWorkTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int num = sc.nextInt();
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (time >= 2) {
                sum = Math.max(sum, num * 2);
            }
            while (time > 0) {
                list.add(num);
                time--;
            }
        }
        sum = Math.max(sum,min+max);
        System.out.println(sum);
//        Integer[] times = list.toArray(new Integer[list.size()]);
//        Arrays.sort(times);
//        int maxVal = Integer.MIN_VALUE;
//        int i = 0, j = times.length - 1;
//        while (i < j) {
//            maxVal = Math.max(maxVal, times[i] + times[j]);
//            i++;
//            j--;
//        }
//        System.out.println(maxVal);
    }
}
