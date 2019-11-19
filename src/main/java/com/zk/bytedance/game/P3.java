package com.zk.bytedance.game;

import java.util.Scanner;

/**
 * 7 4
 * 10 0 2 1 1 0 1
 */
public class P3 {
    public int solution(int[] array,int loc){
        if (loc <0 || loc >= array.length){
            return -1;
        }
        int primary = loc;
        int len = array.length;
        if (array[loc] == 0){
            return -1;
        }
        boolean rightCan = true;
        int index = loc;
        int rightSteps = 0;
        //一直向右跳
        while (loc < len){
            if (array[loc] > 0){
                loc = loc + array[loc];
                index = loc;
                ++rightSteps;
            }else if (array[loc] == 0){
                rightCan = false;
                break;
            }
            if (index >= len){
                rightCan = true;
                break;
            }
        }
        loc = primary;
        int leftIndex = loc;
        int leftSteps = 0 ;
        boolean leftCan = true;
        //朝左跳
        while (loc >= 0){
            leftIndex = loc - array[loc];
            leftSteps ++;
            loc = leftIndex;
            if (array[leftIndex] == 0){
                return rightSteps;
            }
            //左边可以跳出去
            if (array[leftIndex]> len - leftIndex){
                break;
            }
        }
        if (leftCan && rightCan){
            return Math.min(leftSteps,rightSteps)+1;
        }else if (rightCan){
            return rightSteps+1;
        }else {
            return leftSteps+1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int loc = Integer.parseInt(s[1]);
        int[] array = new int[num];
        for (int i = 0; i <num ; i++) {
            array[i] = sc.nextInt();
        }
        P3 p  = new P3();
        System.out.println(p.solution(array,loc-1));
    }
}
