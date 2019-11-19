package com.zk.bytedance.practice2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 抓捕孔连顺
 */
public class Problem2 {
    /**
     * 暴力超时
     *
     * @param d
     * @param array
     * @return
     */
    public long soultion(int d, int[] array) {
        long result = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] - array[i] > 19) {
                    break;
                }
                for (int k = j + 1; k < array.length; k++) {
                    if (array[k] - array[i] <= 19) {
                        result++;
                        result = result > 99997867 ? result % 99997867 : result;
                        continue;
                    }
                    if (array[k] - array[i] > 19) {
                        break;
                    }

                }
            }
        }
        return result % 99997867;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int[] array = new int[n];
        BigInteger count = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0, j = 0; i < array.length; i++) {
            while (i >= 2 && array[i] - array[j] > d) {
                j++;
            }
            //当满足a[i] - a[j] < d时，c n 2 从 j+1 到 i 中任取两个2
            if (i - j >= 2) {

                BigInteger temp = new BigInteger(String.valueOf((i - j) * (i - j - 1) / 2));
                count = count.add(temp);
            }
        }
        long mods = 99997867;
        System.out.println(count.mod( BigInteger.valueOf(mods)));
    }


}
