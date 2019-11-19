package com.zk.offer66.from1to10;

import java.util.Arrays;

public class Q6MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            //中间大 右边小
            if (array[middle] > array[right]) {
                left = middle + 1;
            } else if (array[middle] == array[right]) {
                //相等
                right = right - 1;
            } else {
                //左边小
                right = middle;
            }
        }
        return array[left];
    }


    public static void main(String[] args) {
        int[] array = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        Q6MinNumberInRotateArray q6 = new Q6MinNumberInRotateArray();
        System.out.println(q6.minNumberInRotateArray(array));
    }
}
