package com.zk.bytedance.game;

import java.util.Scanner;

/**
 * 双指针 间距为k ,当后面的指针到达链表结束时 输出前面一个链表的值
 */
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int[] array = new int[num];
            for (int i = 0; i <num; i++) {
                array[i] = sc.nextInt();
            }
            int loc = sc.nextInt();
//            if (num-1-loc < 0){
//                System.out.println();
//           }else {
//                System.out.println(array[num-1-loc]);
//            }
            if (num-1-loc < 0){

                System.out.println("null");
            }else {
                int len  = array.length - 1;
                //这里用数组模拟链表 first为前面一个指针，second为后面一个指针
                int dis = loc;
                int first = 0;
                int second = 0;
                while (dis>0){
                    first++;
                    dis--;
                }
                while (first < len){
                    first++;
                    second++;
                }
                //first到达终点
                System.out.println(array[second]);
            }

        }
    }
}
