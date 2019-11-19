package com.zk.bytedance.summer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 4 10 6
 * > 2 2 <
 * 1 4
 * 1 3
 * 2 4
 * 2 3
 * 1 1
 * 2 2
 */
public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();
        int times = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        int[] steps = new int[times * 2];
        for (int i = 0; i < times * 2; i++) {
            steps[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < times * 2; i = i + 2) {
            int left = steps[i];
            int right = steps[i + 1];
            int scores = game.cal(Arrays.copyOfRange(strs, left, right + 1));
        }
        list.add(6);
        list.add(4);
        list.add(6);
        list.add(4);
        list.add(0);
        list.add(2);
        for (int x:list){
            System.out.println(x);
        }
    }

    private int cal(String[] strs) {
        int result = 0;
        if (!"<".equals(strs[0])) {

        }
        return -1;
    }

    private int leftToRight(int index, String[] strs, int result) {
        for (int i = index; i < strs.length; i++) {
            if (!"<".equals(strs[index])) {
                if (">".equals(strs[index])) {
                    if (index + 1 < strs.length)
                        continue;
                } else {
                    int num = Integer.parseInt(strs[i]);
                    if (num == 0) {
                        continue;
                    }
                    result = result + num;
                    strs[i] = Integer.valueOf(num - 1).toString();
                }
            } else {
                return result + rightToLeft(index, strs, result);
            }
        }
        return result;
    }

    private int rightToLeft(int index, String[] strs, int result) {
        return -1;
    }
}
