package com.zk.leetcode.medium.treeandmap;

import com.zk.offer66.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    /**
     * 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findIndex(inorder, preorder[0]);
        root.left = buildTree1(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree1(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }

    public int findIndex(int[] inorder, int num) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTree buildTree = new BuildTree();
        TreeNode node = buildTree.buildTree(pre, inorder);
        System.out.println(node.toString());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0; i<inorder.length;i++) {
            inMap.put(inorder[i],i);
        }
        return builder(preorder, 0 , preorder.length-1, inorder, 0, inorder.length-1, inMap) ;
    }

    TreeNode builder(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer,Integer> inMap) {
        if(iStart>iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = inMap.get(preorder[pStart]);
        root.left = builder(preorder, pStart+1, pStart+index-iStart, inorder, iStart, index-1, inMap);
        root.right = builder(preorder, pStart+index-iStart+1, pEnd, inorder, index+1, iEnd, inMap);
        return root;
    }
}
