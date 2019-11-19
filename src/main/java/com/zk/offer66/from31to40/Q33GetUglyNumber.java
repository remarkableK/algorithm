package com.zk.offer66.from31to40;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author
 */
public class Q33GetUglyNumber {
    /**
     *  依次求出第n个   这个方法直接会超时
     */
    public int solution(int n) {
        if (n <= 6){
            return n;
        }
        int foundNum = 0;
        int number = 0;
        while (foundNum < n){
            number ++ ;
            if (isUglyNum(number)){
                foundNum++;
            }
        }
        return number;
    }

    /**
     * 求输入的数字是否为丑数
     * @param n
     * @return
     */
    private boolean isUglyNum(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Q33GetUglyNumber q33 = new Q33GetUglyNumber();
        System.out.println(q33.solution2(7));
    }

    /**
     * 解题思路见博客
     * @param n
     * @return
     */
    public int solution2(int n){
        int[] array = new int[n];
        array[0] = 1;
        int nextUglyIndex = 1;

        int t1=0,t2=0,t3=0;
        while (nextUglyIndex < n){
            int min =minInThree(array[t1]*2,array[t2]*3,array[t3]*5);
            array[nextUglyIndex] = min;
            while (array[t1]*2 <= array[nextUglyIndex]){
                ++t1;
            }
            while (array[t2]*3 <= array[nextUglyIndex]){
                ++t2;
            }
            while (array[t3]*5 <= array[nextUglyIndex]){
                ++t3;
            }
            nextUglyIndex++;
        }
       return array[n-1];
    }
    private int minInThree(int n1,int n2,int n3){
        int min = Math.min(n1,n2);
        return Math.min(min,n3);
    }

}
