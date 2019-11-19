package com.zk.offer66;

import java.util.LinkedList;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public static TreeNode buildTree(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nums.length; i = i + 2) {
            TreeNode left = null;
            TreeNode right = null;
            if (nums[i] != -1) {
                left = new TreeNode(nums[i]);
            }
            if (nums[i + 1] != -1) {
                right = new TreeNode(nums[i + 1]);
            }
            if (queue.size() > 0) {
                TreeNode head = queue.poll();
                head.left = left;
                head.right = right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
        }
        return root;
    }

}
