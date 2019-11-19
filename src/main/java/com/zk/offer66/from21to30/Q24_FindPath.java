package com.zk.offer66.from21to30;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Q24_FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null || root.val > target){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result =new ArrayList<>();
        search(root,new ArrayList<Integer>(),0,result,target);
        return result;
    }

    /**
     *
     * @param root  传入的结点
     * @param currentList 该结点之前走过的结点集合
     * @param beforeSum 该结点之前的数值和
     * @param result 返回的结果集
     * @param target 目标和
     */
    public void search(TreeNode root,ArrayList<Integer> currentList,int beforeSum,ArrayList<ArrayList<Integer>> result,int target){
        //如果 该结点之前的数值和 + 当前结点数字 > target 退出
        if (root.val + beforeSum > target){
            return;
        }
        //是否存在子树
        boolean existChildren = root.left !=null || root.right != null;
        // 如果到达叶子节点，且和满足，就纳入到结果集
        if (!existChildren && beforeSum+root.val == target){
            ArrayList<Integer> list = (ArrayList<Integer>) currentList.clone();
            list.add(root.val);
            result.add(list);
            return;
        }
        //否则，将当前结点加入到currentList，继续遍历其子树
        currentList.add(root.val);
        //出口，无子节点
        if (root.left!=null){
            search(root.left,currentList,root.val+beforeSum,result,target);
        }
        if (root.right!=null){
            search(root.right,currentList,root.val+beforeSum,result,target);
        }
        //返回上一层前 移除掉当前结点
        if (currentList.size() > 0){
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {10,5,12,4,7};
        TreeNode root = TreeNode.buildTree(nums);
        Q24_FindPath q24_findPath = new Q24_FindPath();
        ArrayList<ArrayList<Integer>> result = q24_findPath.findPath(root,22);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
