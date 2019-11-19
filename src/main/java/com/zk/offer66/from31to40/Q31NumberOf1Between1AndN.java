package com.zk.offer66.from31to40;

/**
 * 待改进有lgn的解法
 */
public class Q31NumberOf1Between1AndN {
    /**
     * 暴力 O(nlogn)
     * @param n
     * @return
     */
    public int solution(int n){
        int num = 0;
        for (int i = 1; i <= n ; i++) {
            num += numberOf1(i);
        }
        return num;
    }
    private int numberOf1(int n){
        int times =0;
        while (n > 0){
            if (n % 10 == 1){
                times++;
            }
            n = n /10;
        }
        return times;
    }


    public static void main(String[] args) {

    }
}
