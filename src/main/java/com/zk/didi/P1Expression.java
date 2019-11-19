package com.zk.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算式转移
 */
public class P1Expression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] array = str.split(" ");
        if (n == 1){
            System.out.println(array[0]);
            return;
        }
        P1Expression p1 = new P1Expression();
        boolean changed = true;
        while (changed) {
            changed = p1.solution(array);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public boolean solution(String[] chars) {
        for (int i = 0; i <= chars.length - 2; i++) {
            if ("+".equals(chars[i])) {
                boolean left = i - 2 < 0 || (!"*".equals(chars[i - 2]) && !"/".equals(chars[i - 2]));
                boolean right = i + 2 >= chars.length || ((!"*".equals(chars[i + 2]) && !"/".equals(chars[i + 2])));
                if (left && right && Integer.parseInt(chars[i - 1]) > Integer.parseInt(chars[i + 1])) {
                    String temp = chars[i - 1];
                    chars[i - 1] = chars[i + 1];
                    chars[i + 1] = temp;
                    return true;
                }
            } else if ("*".equals(chars[i])) {
                boolean left = i - 2 < 0 || (!"/".equals(chars[i - 2]));
                boolean right = i + 2 >= chars.length || ((!"/".equals(chars[i + 2])));

                if (left && right && Integer.parseInt(chars[i - 1]) > Integer.parseInt(chars[i + 1])) {
                    String temp = chars[i - 1];
                    chars[i - 1] = chars[i + 1];
                    chars[i + 1] = temp;
                    return true;
                }
            }
        }
        return false;

    }
}
