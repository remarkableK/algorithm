package com.zk.offer66.from31to40;

import com.zk.offer66.TreeNode;

public class Q38TreeDepth {
    public int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth)+1;
    }
}
