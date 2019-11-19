package com.zk.vmware;

import java.util.Scanner;

/**
 * 神奇计数
 * 给出一个闭区间[a,b]和一个正整数k，请你找出符合如下条件的数x的个数：
 * <p>
 * 1.    数字可以被k整除，即x%k==0;
 * <p>
 * 2.    数字不能被[2,k-1]中的任何一个数整除。（当k-1小于2时，区间可被认为成一个空集，即满足不能被任何一个数整除的条件）
 */
public class MagincNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        if (k - 1 < 2) {
            System.out.println(0);
            return;
        }
        int result = 0;
        for (int i = a; i <= b; i++) {
            boolean ok = true;
            if (i % k == 0) {
                for (int j = 2; j < k; j++) {
                    if (i % j == 0) {
                        ok = false;
                        break;
                    }
                }
                if (ok){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
