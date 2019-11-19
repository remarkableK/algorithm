package com.zk.others;

import com.zk.offer66.TreeNode;

import java.util.Stack;

/**
 * 二叉树非递归遍历
 */
public class TreeInOrderNoRecursion {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = TreeNode.buildTree(nums);
        TreeInOrderNoRecursion.postOrder(treeNode);
    }

    /**
     * 中序遍历递归
     *
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }

    /**
     * 非递归中序遍历
     *
     * @param treeNode
     */
    public static void inOrderNoRecursion(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        //遍历结束的条件是栈是空的或者当前结点也是空的
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                //没有左子树 就是出栈的时候
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 非递归前序遍历 初始的是否要先把根节点压入到栈中
     * @param treeNode
     */
    public static void preOrderNoRecursion(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        //结束条件
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.val);
            //因为要先遍历左子树，所以先把右子树压栈
            if (current.right!=null){
                stack.push(current.right);
            }
            if (current.left!=null){
                stack.push(current.left);
            }
        }
    }

    /**
     * 后去非递归
     * @param head
     */
    public static void postOrder(TreeNode head){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left!=null){
                stack1.push(temp.left);
            }
            if (temp.right!=null){
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()){
            TreeNode current = stack2.pop();
            System.out.println(current.val);
        }
    }


}
