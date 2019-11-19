package com.zk.offer66.from21to30;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 二叉树层次遍历
 * @author
 *
 */
public class Q22_PrintFromTopToBottom {
    /**
     * easy 层次遍历 ，队列解决
     * @param root
     * @return
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //判断一个Linkedlist中是否为空要用size不能用null
        while (queue.size() >0){
            TreeNode firstNode = queue.poll();
            if (firstNode.left!=null){
                queue.add(firstNode.left);
            }
            if (firstNode.right!=null){
                queue.add(firstNode.right);
            }
            result.add(firstNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        ArrayList<Integer> integers = Q22_PrintFromTopToBottom.printFromTopToBottom(root);
        System.out.println(Arrays.toString(integers.toArray()));
    }
}
