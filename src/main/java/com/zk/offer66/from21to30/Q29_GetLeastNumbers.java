package com.zk.offer66.from21to30;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Q29_GetLeastNumbers {
    /**
     * 当前思路 堆排序  小顶堆
     */
    public static ArrayList<Integer> solution(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            //k轮
            for (int j = input.length - 1 - i; j > 0; j--) {
                int parentIndex = j % 2 == 0 ? j / 2 - 1 : j / 2;
                if (input[parentIndex] > input[j]) {
                    //交换
                    int temp = input[parentIndex];
                    input[parentIndex] = input[j];
                    input[j] = temp;
                }
            }
            result.add(input[0]);
            //出堆
            int outTemp = input[0];
            input[0] = input[input.length - 1 - i];
            input[input.length - 1 - i] = outTemp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> res = Q29_GetLeastNumbers.solution2(nums, 4);
        System.out.println(res.toString());
    }

    /**
     * 堆排序
     * top k
     * 复习了一下，上一个版本堆排序好像有点问题，每次应该是从非叶子节点开始向上调
     * 第一个非叶子接节点的下标识 (array.length-1)/2;
     * 小顶堆
     */
    public static ArrayList<Integer> solution2(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //k轮
        for (int i = 0; i < k; i++) {
            //input.length - i 相当于剔除了已经选出的数再进行调整
            for (int j = (input.length - i) / 2 - 1; j >= 0; j--) {
                //找出其子节点的最小值 要注意是
                int minOfChildren = 0;
                if (2 * j + 2 >= input.length - i) {
                    minOfChildren = 2 * j + 1;
                } else {
                    minOfChildren = input[2 * j + 1] < input[2 * j + 2] ? 2 * j + 1 : 2 * j + 2;
                }
                if (input[minOfChildren] < input[j]) {
                    int temp = input[j];
                    input[j] = input[minOfChildren];
                    input[minOfChildren] = temp;
                }
            }
            result.add(input[0]);
            //出堆，继续调整
            int temp = input[0];
            input[0] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
        return result;
    }
}
