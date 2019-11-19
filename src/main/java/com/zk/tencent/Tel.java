package com.zk.tencent;

import java.util.Scanner;

/**
 * 电话号码
 */
public class Tel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            if (len < 11) {
                System.out.println("NO");
                continue;
            }
            int index = str.indexOf("8");
            if (index < 0){
                System.out.println("NO");
                continue;
            }
            if (len - index < 11) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
