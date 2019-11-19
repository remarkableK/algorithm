package com.zk.webank;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long multi = 1;
        for (int i = 2; i <= n; i++) {
            multi = multi * i;
            multi = multi % (1000000+3);
        }
        System.out.println(multi);
    }
}
