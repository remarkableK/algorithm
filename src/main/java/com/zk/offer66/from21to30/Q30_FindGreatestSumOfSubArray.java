package com.zk.offer66.from21to30;

/**
 * 连续子数组最大和
 * {6,-3,-2,7,-15,1,2,2},
 */
public class Q30_FindGreatestSumOfSubArray {
    /**
     * 传统贪心，不适用于全负数
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum + array[i] < array[i]){
                sum = array[i];
            }else {
                sum  += array[i];
            }
            result = result > sum ? result : sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-2,-8,-1,-5,-9};
        int[] array1 = {1,2,-4,6,-3,-2,7,-15,1,2,2};
        System.out.println(Q30_FindGreatestSumOfSubArray.findGreatestSumOfSubArray(array));
    }

    /**
     * 简单的dp，选与不选的问题。和 上面的思路其实是一样的
     * @param array
     * @return
     */
    public static int solution(int[] array){
        //记录当前所有子数组的和的最大值
        int res = array[0];
        //包含array[i]的连续数组最大值
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            //状态转移方程,如果之前子数组的和加上当前元素小于当前元素，就
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
