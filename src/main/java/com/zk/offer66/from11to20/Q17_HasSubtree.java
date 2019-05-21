package com.zk.offer66.from11to20;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Q17_HasSubtree {
    public boolean hasSubtree1(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1!=null && root2!=null){
            //如果当前结点的数值相等，调用子函数刦判断其子树
            if (root1.val == root2.val){
                result = preOrder(root1,root2);
                //判断左子树中是否存在相等的情况
            }
            if (!result){
                result=hasSubtree1(root1.left,root2);
            }
            //当左子树不存，判断右子树中是否存在相等的
            if (!result){
                result=hasSubtree1(root1.right,root2);
            }
        }
        return result;
    }
    public boolean preOrder(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return preOrder(root1.left,root2.left)&&preOrder(root1.right,root2.right);
    }
}
