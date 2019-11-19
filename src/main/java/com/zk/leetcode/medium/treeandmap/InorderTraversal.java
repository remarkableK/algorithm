package com.zk.leetcode.medium.treeandmap;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;

        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] vals = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTree(vals);
        InorderTraversal in = new InorderTraversal();
        System.out.println(Arrays.toString(in.inorderTraversal(root).toArray()));
    }
}
