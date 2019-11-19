package com.zk.offer66.from51to60;

/**
 * 字符串是否表示数值（包括整数和小数)
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Q53IsNumeric {
    public static boolean isNumeric(char[] str) {
        boolean hasE = false, hasDot = false, hasSign = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    //不第一位出现的出现必须在E后面
                    return false;
                }
            } else if (str[i] == 'e' || str[i] == 'E') {
                //第一次出现
                if (!hasE && i != str.length - 1) {
                    hasE = true;
                } else {
                    return false;
                }
            } else if (str[i] == '.') {
                //不能出现两次或出现在e后面
                if (hasE || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "-1E-16";
        char[] chars = s.toCharArray();
        System.out.println(Q53IsNumeric.isNumeric(chars));
    }
}
