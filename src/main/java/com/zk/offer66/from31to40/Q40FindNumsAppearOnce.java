package com.zk.offer66.from31to40;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Q40FindNumsAppearOnce {
    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public void solution(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], false);
            } else {
                map.put(array[i], true);
            }
        }
        boolean first = false;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()
        ) {
            if (!entry.getValue() && !first) {
                num1[0] = entry.getKey();
                first = true;
            } else if (!entry.getValue()) {
            num2[0] = entry.getKey();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,6,2,2,3,3,8,8,9,9,1000000,1000000};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        Q40FindNumsAppearOnce q40 = new Q40FindNumsAppearOnce();
        q40.solution2(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }
    /**
     * 使用异或，一组数字中只有一个数字出现两个，一个数组x出现一次，依次异或所有数字，最后的结果就是这个x
     * 有两个数字只出现一次的思路就是将数组分别两个子数组，每个子数组中各有一个只出现一次的数字
     */
    public void solution2(int[] array, int[] num1, int[] num2){
        if (array == null || array.length < 2) {
            return;
        }
        int firstOr = array[0];
        //最后的结果是两个只出现一次的数字异或
        for (int i = 1; i < array.length ; i++) {
            firstOr = firstOr ^ array[i];
        }
        //找到最高位为不为1的
        int times = 0;
        while (firstOr >0){
            firstOr = firstOr >> 1;
            times++;
        }
        //阈值 第n位为1的
        int gap = (int)  Math.pow(2,times-1);
        for (int i = 0; i < array.length ; i++) {
            if ((array[i] & gap) <=0){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

}
