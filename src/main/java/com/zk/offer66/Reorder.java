package com.zk.offer66;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Reorder {
    /**
     * 思路：从开始依次查找每个偶a，并从该偶数开始找到一个奇数b，
     * 然后从该奇数a开始截止b 该a前面数字依次向后移动一位，原本偶数a的位置赋值为b
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (array.length < 2){
            return;
        }
        int begin = 0;
        while (begin < array.length){
            //找到第一个偶数
            while (begin < array.length&&(array[begin]&1)!=0){
                begin++;
            }
            //从该偶数开收找一个奇数
            int end = begin+1;
            while ( end < array.length &&(array[end]&1)!=1){
                end++;
            }
            if (end >= array.length){
                break;
            }
            int temp = array[end];
            //移动一位
            for (int i = end; i > begin ; i--) {
                array[i] = array[i-1];
            }
            array[begin] = temp;
            //开始下一轮
            begin++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Reorder.reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
