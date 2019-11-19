package com.zk.offer66.from41to50;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Q48Add {
    /**
     * 十进制的加法  5 + 7 分解为三步，一.不考虑进位得到2,二只考虑进位得到10，三，将两者相加，直到不产生进位
     */
    public int solution(int num1, int num2) {
        //在二进制中，不考虑进位的加法就是异或^，只计算进位就是（a&b）<<1，然后重复将新得到的结果按上述步骤相加直到没有进位产生
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
