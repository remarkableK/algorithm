package com.zk.leetcode;

import com.zk.offer66.TreeNode;

import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            if (contains(root.left, q) || contains(root.right, q)) {
                return root;
            }
        } else if (root.val == q.val) {
            if (contains(root.left, p) || contains(root.right, p)) {
                return root;
            }
        } else {
            boolean leftContainsP = contains(root.left, p);
            boolean leftContainsQ = contains(root.left, q);
            //都在左
            if (leftContainsP && leftContainsQ) {
                return lowestCommonAncestor1(root.left, p, q);
            } else if ((!leftContainsP && !leftContainsQ)) {
                //都在右
                return lowestCommonAncestor1(root.right, p, q);
            } else {
                //一左一右
                return root;
            }
        }
        return null;
    }

    /**
     * 先序遍历，判断是否包含某一个结点
     *
     * @param root
     * @param target
     * @return
     */
    private boolean contains(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == target.val) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = TreeNode.buildTree(nums);
        LowestCommonAncestor1 low = new LowestCommonAncestor1();
        System.out.println(low.contains(treeNode, new TreeNode(3)));
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }else if (left == null && right!=null){
            return right;
        }else if (left!=null){
            return left;
        }else {
            return null;
        }
    }
}
