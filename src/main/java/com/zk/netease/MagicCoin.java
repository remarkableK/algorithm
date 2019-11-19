package com.zk.netease;

import java.util.Scanner;

public class MagicCoin {
    public String solution(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "2";
        }
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append(2);
        } else {
            sb.append(1);
        }
        while (n > 2) {
            //如果是偶数
            if (n % 2 == 0) {
                if ((n / 2 - 1) % 2 == 0) {
                    sb.append(2);
                } else {
                    sb.append(1);
                }
                n = n / 2 - 1;
            } else {
                //奇数
                if ((n / 2) % 2 == 0) {
                    sb.append(2);
                } else {
                    sb.append(1);
                }
                n = n / 2;
            }
        }
        String reverse = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for (int i = reverse.length() - 1; i >= 0; i--) {
            sb2.append(reverse.charAt(i));
        }
        return sb2.toString();
    }

    public static void main(String[] args) {
        MagicCoin magicCoin = new MagicCoin();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(magicCoin.solution(n));
        }


    }
}
