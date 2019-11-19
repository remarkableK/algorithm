package com.zk.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * 第二次
 */
public class Permute2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute2 permute2 = new Permute2();
        List<List<Integer>> res = permute2.permute(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums,0,result);
//        List<Integer>[] t = (List<Integer>[]) result.toArray();
//        Arrays.sort(t);
//        result.clear();
//        result.addAll(Arrays.asList(result));
        return result;
    }

    public void recursion(int[] nums,int pos,List<List<Integer>> result){
        if(pos == nums.length-1){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++){
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }
        for(int i = pos ; i<nums.length;i++ ){
            int t = nums[pos];
            nums[pos] = nums[i];
            nums[i] = t;
            recursion(nums,pos+1, result);
            t = nums[pos];
            nums[pos] = nums[i];
            nums[i] = t;
        }
    }
}
