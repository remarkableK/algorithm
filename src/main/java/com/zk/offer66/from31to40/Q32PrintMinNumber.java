package com.zk.offer66.from31to40;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Q32PrintMinNumber {
    public String solution(int[] numbers){
        int len = numbers.length;
        if(len ==0){
            return "";
        }
        if(len ==1) {
            return String.valueOf(numbers[0]);
        }
        StringBuffer res = new StringBuffer();
        String [] str = new String[len];
        for(int i=0; i<len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (int i = 0; i < len; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        Q32PrintMinNumber q = new Q32PrintMinNumber();
        System.out.println(q.solution(numbers));
    }

}
