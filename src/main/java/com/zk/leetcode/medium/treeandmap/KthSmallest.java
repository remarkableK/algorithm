package com.zk.leetcode.medium.treeandmap;

import com.zk.offer66.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    /**
     * 先序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if (k == 0) {
                return temp.val;
            }
            root = temp.right;
        }
        return 0;
    }

    public static void main(String[] args) {
//        Integer[] vals = {1,2,3,4,5,6,7};
//        TreeNode root = TreeNode.buildTree(vals);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest1(root,2));
    }
}
