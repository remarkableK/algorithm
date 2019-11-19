package com.zk.netease;

import java.util.Arrays;
import java.util.Scanner;

public class String3 {
    public double solution(String s){
        char[] array = s.toCharArray();
        if (array.length == 0 ){
            return 0;
        }
        int sum = 0;
        int kinds = 1;
        int times = 1;
        int old = array[0];
        for (int i = 1; i <array.length ; i++) {
            if (array[i] == old){
                times++;
            }else {
                kinds++;
                sum += times;
                times = 1;
                old = array[i];
            }
        }
        sum += times;
        return (double)sum/kinds;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String3 string3 = new String3();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.printf("%.2f",string3.solution(s));
            System.out.println();
        }
    }
}
