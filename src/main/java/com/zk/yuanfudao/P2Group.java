package com.zk.yuanfudao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P2Group {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < groups; i++) {
            int persons = sc.nextInt();
            int[] nums = new int[persons];
            for (int j = 0; j < persons; j++) {
                nums[j] = sc.nextInt();
            }
            int result = 0;
            Arrays.sort(nums);
            while (nums[persons - 3] > 0) {
                //找到一个不为0的
                int k = 0;
                while (nums[k] == 0) {
                    k++;
                }
                result+= nums[k];
                int temp = nums[k];
                nums[k] =0;
                nums[k+1] = nums[k+1] - temp;
                nums[k+2] = nums[k+2] - temp;
                Arrays.sort(nums);
            }
            list.add(result);
        }
        for (int x: list
             ) {
            System.out.println(x);
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
}
