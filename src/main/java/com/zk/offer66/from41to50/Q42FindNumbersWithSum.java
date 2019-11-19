package com.zk.offer66.from41to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Q42FindNumbersWithSum {
    public ArrayList<Integer> solution(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int num1 = Integer.MAX_VALUE;
        int num2 = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (set.contains(sum - value)) {
                if ((sum - value) * value < num1 * num2) {
                    num1 = sum - value;
                    num2 = value;
                }
            } else {
                set.add(value);
            }
        }
        if (num1 == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        if (num1 > num2) {
            result.add(num2);
            result.add(num1);
        } else {
            result.add(num1);
            result.add(num2);
        }
        return result;
    }

    /**
     * 思路2 既然是排好序的 左右指针， a+b == sum 越靠近两边的数乘积越小
     *
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> solution2(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            if (array[low] + array[high] == sum) {
                result.add(array[low]);
                result.add(array[high]);
                return result;
            } else if (array[low] + array[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        ArrayList result = new ArrayList();
        result = Q42FindNumbersWithSum.solution2(array,15);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
