package com.zk.netease.summer;

import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int nums = sc.nextInt();
            int[] array = new int[nums];
            boolean existDouble = false;
            HashMap<Integer,Integer> timesMap = new HashMap<>();
            for (int j = 0; j < nums ; j++) {
                array[i] = sc.nextInt();
                if (!timesMap.containsKey(array[i])){
                    timesMap.put(array[i],1);
                }else {
                    timesMap.put(array[i],timesMap.get(array[i])+1);
                    existDouble = true;
                }
            }
            if (existDouble){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
