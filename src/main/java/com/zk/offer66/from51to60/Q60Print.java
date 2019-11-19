package com.zk.offer66.from51to60;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 把二叉树打印成多行
 */
public class Q60Print {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        TreeNode flag = new TreeNode(Integer.MAX_VALUE);
        if (pRoot == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.add(flag);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty() && queue.size()!=1) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek().val != Integer.MAX_VALUE) {
                TreeNode current = queue.poll();
                temp.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right!=null){
                    queue.add(current.right);
                }
            }
            if (!queue.isEmpty() && queue.peek().val == Integer.MAX_VALUE){
                queue.poll();
                queue.add(flag);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] array = {8,6,10,5,7,9,11};
        TreeNode root = TreeNode.buildTree(array);
        Q60Print q59 = new Q60Print();
        ArrayList<ArrayList<Integer>> list = q59.print(root);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
