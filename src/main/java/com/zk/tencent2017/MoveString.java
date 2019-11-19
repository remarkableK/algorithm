package com.zk.tencent2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [编程题]算法基础-字符移位
 */
public class MoveString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.length() == 1) {
                System.out.println(s);
            } else {
                char[] chars = s.toCharArray();
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (chars[i] >= 'A' && chars[i] <= 'Z') {
                        int j = i + 1;
                        while (j < s.length() && (chars[j] >= 'a' && chars[j] <= 'z')) {
                            char temp = chars[j];
                            chars[j] = chars[j - 1];
                            chars[j - 1] = temp;
                            j++;
                        }
                    }
                }
                System.out.println(new String(chars));
            }
        }
    }
}
