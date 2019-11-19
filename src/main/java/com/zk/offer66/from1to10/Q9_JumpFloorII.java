package com.zk.offer66.from1to10;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 变态版跳台阶，吃糖果
 */
public class Q9_JumpFloorII {
    public int solution(int target) {
        if(target <2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target ;i ++){
            int sum = 0 ;
            for(int j = 1; j < target ;j++){
                sum += dp[j];
            }
            dp[i] = sum +1;
        }
        return dp[target];
    }

    public static void main(String[] args) {
//        Q9_JumpFloorII q9_jumpFloorII = new Q9_JumpFloorII();
//        System.out.println(q9_jumpFloorII.solution(10));
        String[] array = {"a","b","c"};
        Arrays.asList(array).stream().forEach(x-> System.out.println(x));
//        Arrays.asList(array).stream().forEach(System.out::println);
//
    }
}
