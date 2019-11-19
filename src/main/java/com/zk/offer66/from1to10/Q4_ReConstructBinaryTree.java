package com.zk.offer66.from1to10;

import com.zk.offer66.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class Q4_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = getIndex(pre[0], in);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;
    }

    public int getIndex(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 2刷 不需要用赋复制数组，传下标
     */
    // 缓存中序遍历数组每个值对应的索引
    private HashMap<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * @param pre  前序续租
     * @param preL 前序左指针
     * @param preR 前序右指针
     * @param inL  中序左指针
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        //左子树的长度
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }


    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree3(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0);
    }

    public TreeNode construct(int[] preorder, int preL, int preR, int[] inorder, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preL]);
        int inIndex = map.get(preorder[preL]);
        int len = inIndex - preL;
        node.left = construct(preorder, preL + 1, preL + len, inorder, inL);
        node.right = construct(preorder, preL + len + 1, preR, inorder, inL + len + 1);
        return node;
    }
}
