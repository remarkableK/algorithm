package com.zk.offer66.from61to66;

import java.util.ArrayList;
import java.util.Arrays;

public class Q64MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0||size > num.length) {
            return new ArrayList<>();
        }
        int i = 0;
        int j = size - 1;
        while (j < num.length) {
            result.add(finMax(num, i, j));
            i++;
            j++;
        }
        return result;
    }

    private static int finMax(int[] num, int i, int j) {
        int min = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            if (num[k] > min) {
                min = num[k];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(Q64MaxInWindows.maxInWindows(num, 3).toArray()));
    }
}
