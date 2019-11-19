package com.zk.bytedance.spring;

import java.util.Scanner;

public class DosGame {
    public int solution(int[] array){
        int energy = 0;
        for (int i = array.length-1; i >=1 ; i--) {
            energy = energy + array[i] - array[i-1];
        }
        return  energy + array[0];
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i <num; i++) {
            array[i] = sc.nextInt();
        }
        DosGame dosGame = new DosGame();
        System.out.println(dosGame.solution(array));
    }
}
