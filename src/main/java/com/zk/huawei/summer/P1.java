package com.zk.huawei.summer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int n = Integer.parseInt(number, 16);
        if (n == 0 || n == 1) {
            System.out.println(n);
        } else {
            String[] strs = new String[n - 1];
            for (int i = 0; i < n - 1; i++) {
                strs[i] = sc.next();
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                if ("A".equals(strs[i])) {
                    list.add("12");
                    list.add("34");
                } else if ("B".equals(strs[i])) {
                    list.add("AB");
                    list.add("CD");
                } else {
                    list.add(strs[i]);
                }
            }
            //大于丢弃
            int firstNum = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size() && firstNum < 255; i++) {
                res.append(list.get(i)).append(" ");
                firstNum++;
            }
            String numHex = Integer.toHexString(firstNum+1).toUpperCase();
            System.out.println(numHex+" "+res.toString().trim());
        }
    }
}
