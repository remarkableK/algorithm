package com.zk.dji;

import java.util.HashMap;
import java.util.Scanner;

public class Shopping {
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            sum = 0;
            int money = sc.nextInt();
            int nums = sc.nextInt();
            int[] values = new int[nums];
            HashMap<Integer, Integer> map = new HashMap<>(nums);
            for (int i = 0; i < nums; i++) {
                values[i] = sc.nextInt();
                map.put(i, values[i]);
            }
            //特别喜欢的零食数量
            int m = sc.nextInt();
            int[] fav = new int[m];
            for (int i = 0; i < m; i++) {
                fav[i] = sc.nextInt();
            }
            int[] unfav = new int[nums - m];
            int flag = 0;
            for (int i = 1; i <= nums; i++) {
                if (!map.containsKey(i)) {
                    unfav[flag++] = i;
                }
            }
            recursion(sum, money, map, fav, 0, unfav);
            System.out.println(1);
        }
    }

    private static void recursion(int sum, int money, HashMap<Integer, Integer> map, int[] fav, int index, int[] unfav) {
        //所有的
        if (index == fav.length) {

        }
        int value = map.get(fav[index]);
        int nums = fav[index] / value;
    }
}
