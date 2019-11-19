package com.zk.vmware;

import java.util.Scanner;

/**
 * 第K个n位数的回文数
 * 5
 * 3 4
 * 1 5
 * 2 9
 * 4 18
 * 5 201
 * <p>
 * <p>
 * 131
 * 4
 * 99
 * 2772
 * 30003
 */
public class KthNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int half = 0;
            if (n % 2 == 0) {
                half = (int) Math.pow(10, n / 2 - 1) + k - 1;
                String res = Integer.toString(half);
                StringBuilder reverse = new StringBuilder(res).reverse();
                System.out.println(res + reverse.toString());

            } else {
                half = (int) Math.pow(10, n / 2) + k - 1;
                String res = Integer.toString(half);
                if (n == 1){
                    System.out.println(half-1);
                }else {
                    StringBuilder reverse = new StringBuilder(res.substring(0, res.length() - 1)).reverse();
                    System.out.println(res + reverse.toString());
                }
            }
        }


    }
}
