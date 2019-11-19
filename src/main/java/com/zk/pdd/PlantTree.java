package com.zk.pdd;

import java.util.*;

public class PlantTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] trees = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int begin = sc.nextInt();
            int end = sc.nextInt();
            if (!map.containsKey(begin)) {
                map.put(begin, end);
            } else {
                int last = map.get(begin);
                if (last >= end){
                    continue;
                }else {
                    begin = last;
                }
            }
            int tempRes = 0;
            for (int j = begin; j <= end; j++) {
                if (trees[j] == 0) {
                    trees[j] = 1;
                    tempRes++;
                }
            }
            sum += tempRes;
            System.out.println(sum);
        }
    }
}
