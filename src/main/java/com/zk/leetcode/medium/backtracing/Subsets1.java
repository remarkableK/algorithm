package com.zk.leetcode.medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法求子集
 */
public class Subsets1 {
    /**
     * 集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。
     */
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //一共2^n种
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            //n个数
            for (int j = 0; j < nums.length; j++) {
                //
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }
    //backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtracking(ans, tempList, nums, 0);
        return ans;
    }

    /**
     * 第二种 回溯法
     */
    public void backtracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
        //空集
        ans.add(new ArrayList(tempList));
        for (int i = start; i < nums.length; i++) {
            //加上当前的数字
            tempList.add(nums[i]);
            backtracking(ans, tempList, nums, i + 1);
            //移除掉最后添加的数字
            tempList.remove(tempList.size() - 1);
        }
    }


    /**
     * 第三种 dfs
     * 集合中每个元素的选和不选，构成了一个满二叉状态树，
     * 比如，左子树是不选，右子树是选，
     * 从根节点、到叶子节点的所有路径，构成了所有子集。
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。
     * DFS，前序遍历
     */
    public void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        //出口
        if (i >= nums.length){
            return;
        }
        ArrayList<Integer> subset0 = new ArrayList<>(subset);
        //先序添加上一次的结果
        res.add(subset0);
        //不选当前结点进行遍历
        preOrder(nums,i+1,subset0,res);
        subset0.add(nums[i]);
        //选择当前结点进行遍历
        preOrder(nums,i+1,subset0,res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets1 subsets1 = new Subsets1();
        List<List<Integer>> res = new ArrayList<>();
        res = subsets1.subsets(nums);

        res.add(new ArrayList<>());
        ArrayList<Integer> subset = new ArrayList<>();
        subsets1.preOrder(nums, 0, subset, res);
        System.out.println(Arrays.toString(res.toArray()));
    }
}