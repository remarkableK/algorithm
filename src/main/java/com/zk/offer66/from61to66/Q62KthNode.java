package com.zk.offer66.from61to66;

import com.zk.offer66.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 */
public class Q62KthNode {
    /**
     * 中序非递归遍历
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode kthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                k--;
                TreeNode node = stack.pop();
                if (k == 0) {
                    return node;
                }
                if (node.right != null) {
                    pRoot = node.right;
                }
            }
        }
        return null;
    }

}
