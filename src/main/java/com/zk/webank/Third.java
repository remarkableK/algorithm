package com.zk.webank;

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int begin = sc.nextInt();
            int end = sc.nextInt();
            if (!map.containsKey(begin)) {
                map.put(begin, 1);
            } else {
                map.put(begin, map.get(begin)+1);

            }
            if (!map.containsKey(end)) {
                map.put(end, 1);
            } else {
                map.put(end, map.get(end)+1);

            }
        }
        int enter = sc.nextInt();
        int exit = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int x : map.keySet()
        ) {
            if (x != enter && x != exit && map.get(x) == 1) {
                list.add(x);
            }
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int t:array
             ) {
            sb.append(t).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
