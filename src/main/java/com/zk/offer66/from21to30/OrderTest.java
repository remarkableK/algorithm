package com.zk.offer66.from21to30;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTest {
    /**
     * 前序遍历非递归
     * @param root
     */
    public static void noRecursionPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nodes = {5,3,7,2,4,6,8};
        TreeNode root = TreeNode.buildTree(nodes);
        OrderTest.noRecursionPreOrder(root);
//        System.out.println(Arrays.toString(OrderTest.noRecursionPosOrder(root).toArray()));
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     */
    public static void noRecursionInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.val);
            root = node.right;
        }
    }

    /**
     * 后序遍历非递归
     * 需要两个栈
     *
     * @param root
     */
    public static List<TreeNode> noRecursionPosOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode current, pre = null;
        stack.push(root);
        while (!stack.empty()) {
            current = stack.peek();
            //对于一个节点p，先将其压入栈中，
            //1 p不存在左右子树，可以直接访问 (current.left == null && current.right == null)
            //2 P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点 pre 前一个结点
            if ((current.left == null && current.right == null) || (pre != null && (current.left == pre || current.right == pre))) {
                TreeNode temp = stack.pop();
                list.add(temp);
                System.out.println(temp.val);
                pre = temp;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        return list;
    }
}
