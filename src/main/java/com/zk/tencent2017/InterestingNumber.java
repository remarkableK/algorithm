package com.zk.tencent2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 有趣的数字
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 * @author 95620
 */
public class InterestingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            int maxRes = 0;
            int minRes = 0;
            //全部相等
            if (nums[0] == nums[n - 1]) {
                minRes = n * (n - 1) / 2;
                System.out.println(minRes + " " + maxRes);
                continue;
            }
            //map用来统计
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            //求最小的
            if (map.size() == n) {
                for (int i = 1; i < n; i++) {
                    if (nums[i] - nums[i - 1] == min) {
                        minRes++;
                    } else if (nums[i] - nums[i - 1] < min) {
                        min = nums[i] - nums[i - 1];
                        minRes = 1;
                    }
                }
            } else {
                //如果有重复出现的最小差肯定是0
                for (int x : map.keySet()) {
                    int t = map.get(x);
                    if (t > 1) {
                        minRes += (t * (t - 1) / 2);
                    }
                }
            }
            //求最大差
            int maxNum = map.get(nums[n - 1]);
            int minNum = map.get(nums[0]);
            maxRes = maxNum * minNum;
            System.out.println(minRes + " " + maxRes);
        }
    }
}
