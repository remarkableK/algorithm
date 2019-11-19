package com.zk.netease.p2019a2;

import java.util.Scanner;
/**
 * 午睡
 */
public class Sleep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int sum = 0;
        int[] interests = new int[n];
        //记录当前为止不瞌睡的课程
        for (int i = 0; i < n; i++) {
            interests[i] = sc.nextInt();
            if (interests[i] == 1) {
                sum += scores[i];
            }
        }
        int max = 0;
        int index = 0;
        while (index < n) {
            //找到第一个瞌睡的
            while (index < n && interests[index] != 0) {
                index++;
            }
            //距离结尾不足k个可以跳过，肯定没有前面的大
            if (index > n-k+1) {
                break;
            }
            //获取后面的
            int temp = 0;
            int nums = k;
            int flag = index;
            while (nums > 0 && flag < n) {
                if (interests[flag] == 0) {
                    temp += scores[flag];
                }
                flag++;
                nums--;
            }
            max = Math.max(max, temp);
            index++;
        }
        System.out.println(sum+max);
    }
}
