package com.zk.bytedance.practice2;

import java.util.*;

/**
 * [编程题] 特征提取
 */
public class Problem4 {
    public int solution(String[] array) {
        int len = array.length;
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            String s1 = array[i];
            String[] s1Arr = s1.split(" ");
            String s2 = array[i + 1];
            String[] s2Arr = s2.split(" ");
            HashSet<String> set = new HashSet<>();
            //没有元素就清空一次
            if ("0".equals(s1Arr[0]) || "0".equals(s2Arr[0])) {
                map.clear();
            }
            for (int j = 1; j < s1Arr.length - 1; j = j + 2) {
                String temp = s1Arr[j] + "," + s1Arr[j + 1];
                //保存上一个数组的动作帧
                set.add(temp);
            }
            for (int j = 1; j < s2Arr.length - 1; j = j + 2) {
                String current = s2Arr[j] + "," + s2Arr[j + 1];
                if (set.contains(current)) {
                    if (map.containsKey(current)) {
                        map.put(current, map.get(current) + 1);
                    } else {
                        map.put(current, 2);
                    }
                    max = max > map.get(current) ? max : map.get(current);
                } else {
                    if (map.containsKey(current)) {
                        map.remove(current);
                    }
                }
            }
        }
        return max == 0 ? 1 : max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = Integer.parseInt(sc.nextLine());
        Problem4 problem4 = new Problem4();
        for (int i = 0; i < groups; i++) {
            int lines = Integer.parseInt(sc.nextLine());
            String[] strings = new String[lines];
            for (int j = 0; j < lines; j++) {
                strings[j] = sc.nextLine();
            }
            System.out.println(problem4.solution(strings));
        }
    }
}
