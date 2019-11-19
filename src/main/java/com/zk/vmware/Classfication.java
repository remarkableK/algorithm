package com.zk.vmware;

import com.zk.weicelue.ThreadTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 分类
 * 4
 * 0 10
 * 30 20
 * 1 4
 * 1 6
 * <p>
 * 10
 */
public class Classfication {
    static class Container {
        int ai;
        int bi;

        public Container(int ai, int bi) {
            this.ai = ai;
            this.bi = bi;
        }

        @Override
        public String toString() {
            return ai + " " + bi;
        }
    }

    static int res = 0;
    static long minSumBi = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        List<Container> lista = new ArrayList<>();
        List<Container> listb = new ArrayList<>();
        dfs(a, b, 0, n, lista, listb);

        System.out.println(minSumBi);
        Thread.currentThread().interrupt();
    }

    static void dfs(int[] a, int[] b, int index, int len, List<Container> lista, List<Container> listb) {
        if (index == len) {
            long sumAi = 0;
            long sumBi = 0;
            for (int i = 0; i < listb.size(); i++) {
                sumAi += listb.get(i).ai;
                sumBi += listb.get(i).bi;
            }
            if (sumAi >= lista.size()) {
                minSumBi = Math.min(minSumBi, sumBi);
            }
            return;
        }
        ArrayList<Container> list1 = new ArrayList<Container>(lista);
        list1.add(new Container(a[index], b[index]));
        dfs(a, b, index + 1, len, list1, listb);
        ArrayList<Container> list2 = new ArrayList<Container>(listb);
        list2.add(new Container(a[index], b[index]));
        dfs(a, b, index + 1, len, lista, list2);


    }
}
