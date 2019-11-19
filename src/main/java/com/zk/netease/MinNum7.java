package com.zk.netease;

import java.util.Scanner;

public class MinNum7 {
    public int solution(int[] array) {
        int min =Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = absSum(array,i,j);
                if (absSum(array,i,j) < min){
                    min = temp;
                }
            }
        }
        return min;
    }

    public int absSum(int[] array, int begin, int end) {
        int sum = 0;
        for (int i = begin + 1; i <= end; i++) {
            sum += Math.abs(array[i] - array[i - 1]);
        }
        for (int i = 1; i <begin ; i++) {
            sum += Math.abs(array[i] - array[i - 1]);
        }
        for (int i = end+2; i <array.length ; i++) {
            sum += Math.abs(array[i] - array[i - 1]);
        }
        if (begin > 0 && end < array.length-1){
            sum += Math.abs(array[end+1] - array[begin-1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinNum7 minNum7 = new MinNum7();
        while (sc.hasNext()){
            int number = sc.nextInt();
            int[] array = new int[number];
            for (int i = 0; i <number ; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(minNum7.solution(array));
        }
    }
}
