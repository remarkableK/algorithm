package com.zk.netease;

import java.util.Scanner;

public class RebuildArray5 {
    public String solution(int[] array) {
        if (array.length == 1) {
            return "Yes";
        }
        int n4 = 0;
        int oddNumber = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] % 4 == 0) {
                n4++;
            } else if (array[i] % 2 != 0) {
                oddNumber++;
            }
            if (n4 >= len / 2) {
                return "Yes";
            }
        }
        //两种情况 第一被4整除的数的数目大于等于 奇数， 第二141这种情况
        if (n4 >= oddNumber || ((n4 == oddNumber - 1) && (n4 + oddNumber == len))) {
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RebuildArray5 rebuildArray5 = new RebuildArray5();
        int groups = sc.nextInt();
        for (int i = 0; i < groups; i++) {
            int number = sc.nextInt();
            int[] array = new int[number];
            for (int j = 0; j < number; j++) {
                array[j] = sc.nextInt();
            }
            System.out.println(rebuildArray5.solution(array));
        }

    }
}
