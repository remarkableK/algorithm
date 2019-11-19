package com.zk.offer66.from41to50;

public class Q49StrToInt {
    public int solution(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        int flag = 1;
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = len - 1; i >= 1; i--) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                result += (chars[i] - '0') * flag;
                flag = flag * 10;
            } else {
                return 0;
            }
        }
        if (chars[0] >= '0' && chars[0] <= '9') {
            return result + (chars[0] - '0') * flag;
        }
        if (chars[0] == '+') {
            return result;
        }
        if (chars[0] == '-') {
            return -1 * result;
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "123";

    }
}
