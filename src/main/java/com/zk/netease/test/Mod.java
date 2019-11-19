package com.zk.netease.test;

import java.util.Scanner;

/**
 * 数对
 * https://www.nowcoder.com/test/question/done?tid=25631019&qid=168808#summary
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 */
public class Mod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long res = 0;
        if (k == 0) {
            res = (long)n * n;
        } else {
            for (int y = k + 1; y <= n; y++) {
                res += (n / y) * (y - k) + (n % y >= k ? n % y - k + 1 : 0);
            }

        }
        System.out.println(res);
    }
}
