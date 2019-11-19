package com.zk.bytedance.practice2;

import java.util.Scanner;

public class Problem7 {
    public int solution(int[] array) {
        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if ((result + array[i]) % 2 != 0) {
                result = (result + array[i]) / 2 + 1;
            } else {
                result = (result + array[i]) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i <num ; i++) {
            array[i] = sc.nextInt();
        }
        Problem7 p7 = new Problem7();
        System.out.println(p7.solution(array));
    }
}
