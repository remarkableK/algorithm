package com.zk.offer66.from51to60;

import com.zk.offer66.TreeLinkNode;
import com.zk.offer66.TreeNode;

/**
 * 二叉树的下一个结点
 */
public class Q57GetNext {
    /**
     * 分几类
     * 1.有右子树的 就是其右子树的最左边结点
     * 2.没有右子树的，是其父节点的左子树， 就是其父节点
     * 3.没有右子树，是其父节点的右子树，一直向上找直接找到某个结点A ，A无父节点就是A，或者A是其父节点的左子树，就是A的父节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //有右子树的 就是其右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //没有右子树的，是其父节点的左子树
        //没有右子树，是其父节点的右子树
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
