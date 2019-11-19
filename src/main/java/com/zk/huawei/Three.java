package com.zk.huawei;

import java.util.Scanner;

public class Three {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String hexString = sc.nextLine();
            int result = 0;
            int len = hexString.length();
            int mul = 1;
            for (int i = len - 1; i >= 2; i--) {
                if (hexString.charAt(i) == 'A') {
                    result += 10 * mul;
                }
                if (hexString.charAt(i) == 'B') {
                    result += 11 * mul;
                }
                if (hexString.charAt(i) == 'C') {
                    result += 12 * mul;
                }
                if (hexString.charAt(i) == 'D') {
                    result += 13 * mul;
                }
                if(hexString.charAt(i) == 'E'){
                    result += 14*mul;
                }
                if(hexString.charAt(i) == 'F'){
                    result += 15*mul;
                }
                if (hexString.charAt(i)>='0' && hexString.charAt(i) <= '9'){
                    result += (hexString.charAt(i)-'0')*mul;
                }
                mul = mul * 16;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Three three = new Three();
        three.solution();
    }
}
