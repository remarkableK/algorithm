package com.zk.netease.p2019a2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 丰收
 */
public class Fengshou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heaps = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            heaps[i] = sc.nextInt();
            if (i == 0) {
                dp[0] = heaps[0];
            } else {
                dp[i] = dp[i - 1] + heaps[i];
            }
        }
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        int[] temp = Arrays.copyOf(nums, m);
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>(m);
        int index = 0;
        int arrow = 0;
        while (index < m) {
            while (arrow < n && dp[arrow] < temp[index]) {
                arrow++;
            }
            map.put(temp[index], arrow + 1);
            index++;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(nums[i]));
        }
    }
}
