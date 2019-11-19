package com.zk.netease.p2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 牛牛找工作
 */
public class FindJob {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int workNum = sc.nextInt();
            int peoNum = sc.nextInt();
            HashMap<Integer, Integer> salaryMap = new HashMap<>(workNum + peoNum);
            //用一个数组存放能力值 ，前面为工作的，后面为
            int[] a = new int[workNum + peoNum];
            int[] b = new int[peoNum];
            for (int i = 0; i < workNum; i++) {
                int diff = sc.nextInt();
                int salary = sc.nextInt();
                salaryMap.put(diff, salary);
                a[i] = diff;
            }
            for (int i = 0; i < peoNum; i++) {
                int ability = sc.nextInt();
                a[workNum + i] = ability;
                b[i] = ability;
                if (!salaryMap.containsKey(ability)) {
                    salaryMap.put(ability, 0);
                }
            }
            Arrays.sort(a);
            //max保存前一个的最大值
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                max = Math.max(max, salaryMap.get(a[i]));
                salaryMap.put(a[i], max);
            }
            for (int i = 0; i < b.length; i++) {
                System.out.println(salaryMap.get(b[i]));
            }
        }
    }
}
