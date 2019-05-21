package com.zk.offer66.from11to20;

import com.zk.offer66.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Q18_MirrorTree {
    /**
     * 后续遍历二叉树
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
    }
}
