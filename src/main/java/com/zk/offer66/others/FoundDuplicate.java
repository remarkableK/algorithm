package com.zk.offer66.others;

/**
 * 数组中重复的数字
 */
public class FoundDuplicate {
    /**
     * 使用原来的数组作为标记的题
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] numbers, int length, int [] duplication) {
        for(int i = 0 ; i < length;i++){
            while(i!= numbers[i]){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                //交换
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    private static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int[] dup = new int[1];
        System.out.println(FoundDuplicate.duplicate(nums,nums.length,dup));
        System.out.println(dup[0]);
    }
}
