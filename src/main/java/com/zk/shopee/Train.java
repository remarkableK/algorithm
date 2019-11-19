package com.zk.shopee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [编程题]Shopee的零食柜
 * https://www.nowcoder.com/question/next?pid=17091533&qid=377288&tid=26514352
 */
public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int times = n - m;
        List<Integer> list = new ArrayList<>(n);
        int minLeft = 0;
        int minRight = 0;
        int tempSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < times; i++) {
            tempSum = Integer.MAX_VALUE;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) + list.get(j + 1) < tempSum) {
                    tempSum = list.get(j) + list.get(j + 1);
                    minLeft = j;
                    minRight = j + 1;
                }
            }
            List<Integer> temp = new ArrayList<>();
            int j = 0;
            while (j < list.size()) {
                if (j == minLeft) {
                    temp.add(list.get(minLeft) + list.get(minRight));
                    j = j + 2;
                } else {
                    temp.add(list.get(j));
                    j++;
                }
            }
            list = temp;
        }
        int max = Integer.MIN_VALUE;
        for (int x : list
        ) {
            if (x > max) {
                max = x;
            }
        }
        System.out.println(max);
    }
}
