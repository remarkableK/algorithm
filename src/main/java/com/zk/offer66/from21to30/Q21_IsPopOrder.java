package com.zk.offer66.from21to30;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *
 * @author
 */
public class Q21_IsPopOrder {
    /**
     * 思路：1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列
     *
     *（1）首先先判断是否是同样的序列
     *（2）主要的关注点在4,3,5,1,2中的1这个数字，1之后出现了2这个他的后继数字，如果他之前还有3 pop了肯定就不是出栈顺序
     */
    public static boolean  isPopOrder1(int [] pushA,int [] popA) {
        String str1= Arrays.toString(pushA);
        //
        for (int value : popA) {
            String s = value + "";
            if (!str1.contains(s)) {
                return false;
            }
        }
        HashMap<Integer,Integer> indexMap = new HashMap<>(pushA.length);
        for (int i = 0; i <pushA.length ; i++) {
            indexMap.put(pushA[i],i);
        }
        for (int i = 1; i < popA.length-1; i++) {
            boolean existAfter = false;
            //向后找到他的后一个数字
            int indexInPushA = indexMap.get(popA[i]);
            int after;
            if (indexInPushA < pushA.length-1){
                after= pushA[indexMap.get(popA[i])+1];
            }else {
                continue;
            }
            int before;
            if (indexMap.get(popA[i])+2 < popA.length){
                before = pushA[indexMap.get(popA[i])+2];
            }else {
                continue;
            }
            for (int j = i + 1; j <popA.length ;j++ ) {
                if (popA[j]== after) {
                    existAfter = true;
                    break;
                }
            }
            //向前找他的前一个数字
            if (existAfter){
                for (int j = i-1; j >=0 ; j--) {
                    if (popA[j] == before){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1};
        int[] pop = {2};
        System.out.println(Q21_IsPopOrder.isPopOrder1(push,pop));
    }
}
