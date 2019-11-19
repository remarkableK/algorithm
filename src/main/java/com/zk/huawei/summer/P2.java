package com.zk.huawei.summer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P2 p2 = new P2();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = n; i < m; i++) {
                if (p2.isS(i)) {
                    list.add(i);
                }
            }
            if (list.size() == 0) {
                System.out.println(0);
            } else {
                //十位
                int m1 = 0;
                //个位
                int m2 = 0;
                for (int x : list
                ) {
                    if (x < 10) {
                        m2 += x;
                    } else {
                        m2 += x % 10;
                        x = x / 10;
                        m1 += x % 10;
                    }
                }
                System.out.println(Math.min(m1,m2));
            }
        }
    }

    private boolean isS(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
