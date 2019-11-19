package com.zk.offer66.from51to60;

import java.util.Arrays;

/**
 *给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Q51Multiply {
    /**
     *     用两个数组 ，时间换空间
     */
    public int[] solution(int[] a) {
        if (a == null || a.length < 2){
            return a;
        }
        int len = a.length;
        int[] result = new int[len];
        //从前朝后  0 -  i 的乘积
        int[] before = new int[len];
        //从后朝前乘 i- len-1的乘积
        int[] after = new int[len];
        before[0] = a[0];
        for (int i = 1; i <len ; i++) {
            before[i] = before[i-1]*a[i];
        }
        after[len-1] = a[len-1];
        for (int i = a.length -2; i >= 0 ; i--) {
            after[i] = after[i+1]*a[i];
        }
        result[0] = after[1];
        result[len-1] = before[len-2];
        for (int i = 1; i <len-1 ; i++) {
            result[i] = before[i-1] * after[i+1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Q51Multiply q51Multiply = new Q51Multiply();
        int[] result = q51Multiply.solution2(array);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 对角三角形 一个数组
     * @param a
     * @return
     */
    public int[] solution2(int[] a){
        if (a == null || a.length < 2){
            return a;
        }
        int len = a.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i <len ; i++) {
            result[i] = result[i-1] * a[i-1];
        }
        int temp = 1;
        for (int i = len -2; i >= 0 ; i--) {
            temp = temp * a[i+1];
            result[i] = result[i] * temp;
        }
        return result;
    }
}
