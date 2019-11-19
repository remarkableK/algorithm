package com.zk.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class RandomNumber {
    public void solution(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int number = sc.nextInt();
            int[] array = new int[number];
            for (int i = 0; i <number ; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            int index = 0 ;
            for (int i = 1; i < number ; i++) {
                if (array[index] != array[i]){
                    array[++index] = array[i];
                }
            }
            for (int i = 0; i <= index ; i++) {
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.solution();
    }
}
