package com.zk.sort;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        Main ma = new Main();
        ma.quickSort(nums,0,nums.length-1);
        StringBuilder sb = new StringBuilder();
        for(int x :nums){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    private void quickSort(int[] nums,int left,int right){
        int i = left;
        int j = right;
        if(i >= j){
            return;
        }
        int flag = nums[left];
        while(i < j){
            while(i < j && nums[j] >= flag)
                j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= flag)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = flag;
        quickSort(nums,left,i-1);
        quickSort(nums,j+1,right);
    }
}