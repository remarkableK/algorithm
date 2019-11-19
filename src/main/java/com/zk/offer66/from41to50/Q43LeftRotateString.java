package com.zk.offer66.from41to50;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Q43LeftRotateString {
    public String solution(String str,int n) {
        if (str == null || str.trim().length()==0){
            return "";
        }
        if (n > str.length()){
            n = n % str.length();
        }
        return str.substring(n) + str.substring(0,n);
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        Q43LeftRotateString q43LeftRotateString = new Q43LeftRotateString();
        System.out.println(q43LeftRotateString.solution(s,3));
    }
}
