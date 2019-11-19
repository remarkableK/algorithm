package com.zk.bytedance.game;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/candy/
 * leetcode原题 分发糖果
 */
public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (sc.hasNext()) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            P2 p2 = new P2();
            System.out.println(p2.solution3(array));
            n = sc.nextInt();
        }
    }

    /**
     * 暴力 也太暴力了吧 1250ms
     */
    public int solution3(int[] array) {
        boolean changed = true;
        int[] res = new int[array.length];
        Arrays.fill(res, 1);
        int len = array.length;
        while (changed) {
            changed = false;
            for (int i = 0; i < len; i++) {
                //和前面比较 如果比前面的数字大，且糖果少于等于前面
                if (i > 0 && array[i] > array[i - 1] && res[i] <= res[i - 1]) {
                    res[i] = res[i - 1] + 1;
                    changed = true;
                }
                //和后面比较 如果数字比后面的大，且糖果少于后面
                if (i < len - 1 && array[i] > array[i + 1] && res[i] <= res[i + 1]) {
                    res[i] = res[i + 1] + 1;
                    changed = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += res[i];
        }
        return sum;
    }

    /**
     * 两个数组，分别记录从左到右和从右到左满足情况的下的糖果数目，
     * 最后取left2Right[i] 和right2Left[i]中 比较大的那个
     */
    public int twoArraySolution(int[] array) {
        int[] left2Right = new int[array.length];
        int[] right2Left = new int[array.length];
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1] && left2Right[i] <= left2Right[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1] && right2Left[i] <= right2Left[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        return sum;
    }
}
