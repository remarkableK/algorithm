package com.zk.dianxinyun;

import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRaman(n));
    }

    private String intToRaman(int n) {
        String[] a = {"","M","M","MMM","MC","","","","",""};
        String[] b = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] c = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] d = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return a[n/1000] + b[(n%100)/100] + c[(n%100)/10] + d[n % 10];
    }
}
