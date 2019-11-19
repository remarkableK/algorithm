package com.zk.netease;

import java.util.Scanner;

public class ReverseNumber {
    public int solution(int n) {
        char[] temp = String.valueOf(n).toCharArray();
        int flag = 1;
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] - '0' >= 0) {
                sum += (temp[i] - '0') * flag;
                flag = flag * 10;
            }
        }
        return sum + n;
    }

    public static void main(String[] args) {
        ReverseNumber reverseNumber = new ReverseNumber();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(reverseNumber.solution(num));
        }

    }
}
