package com.zk.nowcoder7;

import java.util.Arrays;
import java.util.Scanner;

public class First {
    int max = Integer.MAX_VALUE;

    public int solution(int[] array) {
        sub(array,0);
        return max;
    }

    public void sub(int[] array, int pos) {
        if (pos == array.length - 1) {
            int temp = Math.abs(array[0] - array[array.length - 1]);
            for (int i = 1; i < array.length; i++) {
                if (Math.abs(array[i] - array[i - 1]) > temp) {
                    temp = Math.abs(array[i] - array[i - 1]);
                }
            }
            if (temp < max) {
                max = temp;
            }
            return;
        }

        for (int i = pos; i < array.length; i++) {
            int t = array[pos];
            array[pos] = array[i];
            array[i] = t;
            sub(array,pos+1);
            t = array[pos];
            array[pos] = array[i];
            array[i] = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        First f = new First();
        while (sc.hasNext()){
            int num = sc.nextInt();
            int[] array = new int[num];
            for (int i = 0; i <num ; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(f.solution(array));
        }
    }
}
