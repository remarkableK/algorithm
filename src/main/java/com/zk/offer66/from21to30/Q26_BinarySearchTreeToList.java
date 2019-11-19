package com.zk.offer66.from21to30;

import com.zk.offer66.TreeNode;

import java.util.Stack;

public class Q26_BinarySearchTreeToList {
    /**
     * 递归版
     * 1.将左子树构造成双链表，并返回链表头节点。
     * 2.定位至左子树双链表最后一个节点。
     * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     * 4.将右子树构造成双链表，并返回链表头节点。
     * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     * 6.根据左子树链表是否为空确定返回的节点。
     */
    public TreeNode convert(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        TreeNode leftNode = convert(root.left);
        TreeNode tempLeft = leftNode;
        //如果左子树链表不为空的话，将当前root追加到左子树链表尾部。
        while (tempLeft !=null &&tempLeft.right != null){
            tempLeft = tempLeft.right;
        }
        if (tempLeft!=null){
            tempLeft.right = root;
            root.left = tempLeft;
        }
        //遍历右子树 并将右子树形成的链表的头结点和树的根节点连接
        TreeNode rightNode = convert(root.right);
        if (rightNode != null){
            root.right  = rightNode;
            rightNode.left = root;
        }
        return leftNode != null ? leftNode : root;
    }

    public static void main(String[] args) {
        Integer[] nodes = {5,3,7,2,4,6,8};
        TreeNode root =  TreeNode.buildTree(nodes);
        Q26_BinarySearchTreeToList  q = new Q26_BinarySearchTreeToList();
        TreeNode treeNode = q.convertNoRecursion(root);
        System.out.println(treeNode.toString());
    }

    /**
     * 非递归版本
     * @param root
     * @return
     */
    public  TreeNode convertNoRecursion(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        //记录是否是第一次访问
        boolean firstVisit = true;
        //需要记录前一个结点
        TreeNode pre = null;
        //非递归使用栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        while (head.left != null){
            head = head.left;
        }
        while (root != null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (firstVisit){
                firstVisit = false;
                pre = root;
            }else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            root = root.right;
        }
        return head;
    }
}
