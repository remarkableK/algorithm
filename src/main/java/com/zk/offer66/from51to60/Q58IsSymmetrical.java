package com.zk.offer66.from51to60;

import com.zk.offer66.TreeNode;

/**
 * 对称的二叉树
 */
public class Q58IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || subQues(pRoot.left, pRoot.right);
    }

    public boolean subQues(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return subQues(root1.left, root2.right) && subQues(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 4, 4, 8};
        TreeNode root = TreeNode.buildTree(array);
        Q58IsSymmetrical q58 = new Q58IsSymmetrical();
        System.out.println(q58.isSymmetrical(root));
    }
}
