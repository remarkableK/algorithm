package com.zk.netease.summer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class EngLish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        //询问的次数
        int q = sc.nextInt();
        int[] read = new int[q];
        //所有的份数
        int[] temp = Arrays.copyOf(scores, n);
        Arrays.sort(temp);
        for (int i = 0; i < q; i++) {
            int index = read[i];
            int current = scores[index - 1];
            int time = 0;
            for (int j = 0; j < n; j++) {
                if (temp[j] <= current) {
                    time++;
                }
            }
            double res = (double) (time -1)/n *100;
            System.out.println();
            System.out.printf("%.6f\n",res);
        }
    }
}
