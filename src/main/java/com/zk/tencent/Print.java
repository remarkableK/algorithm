package com.zk.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 7 5
 * 5 8 10 3 6 10 8
 */
public class Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int times = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int index = 0;
        while (index < len && nums[index] == 0) {
            index++;
        }
        if (index < len){
            System.out.println(nums[index++]);
        }else {
            System.out.println(0);
        }
        times--;
        while (times > 0) {
            if (index >= len){
                System.out.println(0);
            }else {
                while (index < len && nums[index] == nums[index - 1]) {
                    index++;
                }
                if (index == len){
                    System.out.println(0);
                }else {
                    System.out.println(nums[index] - nums[index - 1]);
                    index++;
                }
            }
            times--;
        }
    }
}



//import java.util.Arrays;
//        import java.util.Scanner;
//
///**
// * 7 5
// * 5 8 10 3 6 10 8
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int times = sc.nextInt();
//        int[] nums = new int[len];
//        for (int i = 0; i < len; i++) {
//            nums[i] = sc.nextInt();
//        }
//        Arrays.sort(nums);
//        while (times > 0) {
//            int index = 0;
//            while (index < len && nums[index] == 0) {
//                index++;
//            }
//            if (index == len) {
//                System.out.println(0);
//            } else {
//                int cur = nums[index];
//                System.out.println(cur);
//                for (int i = index; i < len; i++) {
//                    nums[i] = nums[i] - cur;
//                }
//            }
//            times--;
//        }
//    }
//}
