package com.zk.ebay;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int groups = sc.nextInt();
        HashMap<String, Integer> resMap = new HashMap<>(n);
        for (int i = 0; i < groups; i++) {
            int begin = sc.nextInt();
            int end = sc.nextInt();
            if (resMap.containsKey(begin + "," + end)) {
                System.out.println(resMap.get(begin + "," + end));
            } else {
                HashMap<Integer, Integer> map = new HashMap<>(end - begin);
                for (int j = begin; j <= end; j++) {
                    if (!map.containsKey(nums[j])) {
                        map.put(nums[j], 1);
                    } else {
                        map.put(nums[j], map.get(nums[j]) + 1);
                    }
                }
                int temp = 0;
                for (int x:map.keySet()
                     ) {
                    if (map.get(x) == 1){
                        temp++;
                    }
                }
                resMap.put(begin + "," + end, temp);
                System.out.println(temp);
            }


        }
    }
}
