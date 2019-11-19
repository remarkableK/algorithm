package com.zk.yuanfudao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P1BaoShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int times = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : nums) {
            if (map.get(x) <= times){
                sb.append(x).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
