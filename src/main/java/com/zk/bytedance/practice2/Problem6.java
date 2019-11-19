package com.zk.bytedance.practice2;

import java.util.Scanner;

public class Problem6 {
    public int solution(int n) {
        int remain = 1024 - n;
        int result = 0;
//        1元、4元、16元、64
        int[] money = {1, 4, 16, 64};
        for (int i = money.length - 1; i >= 0; i--) {
            if (remain != 0) {
                int num = remain / money[i];
                result += num;
                remain = remain - num*money[i];
            } else {
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Problem6 p6 = new Problem6();
        System.out.println(p6.solution(num));
    }
}
