package com.zk.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2
 * 4
 * 5 9 4 7
 * 8
 * 9 13 18 10 12 4 18 3
 */
public class Group {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            int sum1 = 0, sum2 = 0;
            if (len % 2 == 0) {
                if (len == 2) {
                    sum1 = nums[0];
                    sum2 = nums[1];
                } else {
                    int times = len / 4;
                    int left = 0, right = len - 1;
                    while (times > 0) {
                        sum1 = sum1 + nums[left] + nums[right];
                        times--;
                        left++;
                        right--;
                    }
                    for (int j = left; j <= right; j++) {
                        sum2 += nums[j];
                    }
                }
            } else {//奇数个
                int times = len / 4;
                int left = 0, right = len - 1;
                while (times > 0) {
                    sum1 = sum1 + nums[left] + nums[right];
                    times--;
                    left++;
                    right--;
                }
                for (int j = left + 1; j <= right - 1; j++) {
                    sum2 += nums[j];
                }
                //三种情况
                int leftNum = nums[left];
                int rightNum = nums[right];
                int abs1 = Math.abs(sum1 - sum2 - leftNum - rightNum);
                int abs2 = Math.abs(sum1 - sum2 + leftNum - rightNum);
                int abs3 = Math.abs(sum1 - sum2 + leftNum + rightNum);
                if (min(abs1, abs2, abs3) == abs1) {
                    sum2 += leftNum + rightNum;
                } else if (min(abs1, abs2, abs3) == abs2) {
                    sum1 = sum1 + leftNum;
                    sum2 = sum2 + rightNum;
                } else {
                    sum1 += leftNum + rightNum;
                }
            }
            if (sum1 < sum2) {
                System.out.println(sum1 + " " + sum2);
            } else {
                System.out.println(sum2 + " " + sum1);
            }
        }
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
