package com.zk.east;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        String str1 = strs[0].trim();
        String str2 = strs[1].trim();
        String str3 = strs[2].trim();
        Main1 main1 = new Main1();
        main1.solution(str1, str2, str3);
    }

    public void solution(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            System.out.println("FALSE");
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        char[] arr3 = str3.toCharArray();
        boolean[][] dp = new boolean[arr1.length + 1][arr2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= arr1.length; i++) {
            if (arr1[i - 1] != arr3[i - 1]) {
                break;
            } else {
                dp[i][0] = true;
            }
        }
        for (int j = 1; j <= arr2.length; j++) {
            if (arr2[j - 1] != arr3[j - 1]) {
                break;
            } else {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if ((arr1[i - 1] == arr3[i + j - 1] && dp[i - 1][j]) || (arr2[j - 1] == arr3[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        if (dp[arr1.length][arr2.length]) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}