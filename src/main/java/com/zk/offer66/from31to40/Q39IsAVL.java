package com.zk.offer66.from31to40;

import com.zk.offer66.TreeNode;

public class Q39IsAVL {
    public boolean isAVL(TreeNode root){
        if(root == null){
            return true;
        }
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
    }
    private int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth)+1;
    }
}
