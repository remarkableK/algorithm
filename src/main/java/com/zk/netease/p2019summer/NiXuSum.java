package com.zk.netease.p2019summer;

import java.util.Scanner;

public class NiXuSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    sum += (i-j);
                }
            }
        }
        System.out.println(sum);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        NiXuSum ma = new NiXuSum();
//        int[] temp = new int[n];
//        long res = ma.inversePairs(nums, temp, 0, nums.length - 1);
//        System.out.println(res);
//    }


    private long inversePairs(int[] array, int[] temp, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = (left + right) >> 1;
        //左侧的
        long leftCount = inversePairs(array, temp, left, middle);
        //右侧
        long rightCount = inversePairs(array, temp, middle + 1, right);
        //统计当前的
        long count = 0;
        //两个指针分别指向两个数组的末尾
        int i = middle;
        int j = right;
        //合并的位置存放元素的
        int copyLocation = right;
        //进行归并排序
        while (i >= left && j > middle) {
            if (array[i] > array[j]) {
                for (int k = middle + 1; k <= j; k++) {
                    count += array[i] - array[k];
                }
                temp[copyLocation--] = array[i--];
            } else {
                temp[copyLocation--] = array[j--];
            }
        }
        //剩余的部分
        for (; i >= left; i--) {
            temp[copyLocation--] = array[i];
        }
        for (; j > middle; j--) {
            temp[copyLocation--] = array[j];
        }
        System.arraycopy(temp, left, array, left, right - left + 1);
        return (leftCount + rightCount + count);
    }
}
