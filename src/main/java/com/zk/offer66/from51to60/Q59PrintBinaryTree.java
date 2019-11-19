package com.zk.offer66.from51to60;

import com.zk.offer66.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 */
public class Q59PrintBinaryTree {
    /**
     * 要用一个队列加上栈
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        boolean reverse = false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.add(new TreeNode(Integer.MIN_VALUE));
        while (!queue.isEmpty() && queue.peek().val != Integer.MIN_VALUE) {
            ArrayList<Integer> temp = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (!reverse) {
                while (!queue.isEmpty() && queue.peek().val != Integer.MIN_VALUE) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    stack.push(node);
                }
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
                reverse = true;
            } else {
                while (!queue.isEmpty() && queue.peek().val != Integer.MIN_VALUE) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    stack.push(node);
                }
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                reverse = false;
            }
            result.add(temp);
            if (!queue.isEmpty() && queue.peek().val == Integer.MIN_VALUE) {
                queue.poll();
                queue.add(new TreeNode(Integer.MIN_VALUE));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] treeNode = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        TreeNode tree = TreeNode.buildTree(treeNode);
        Q59PrintBinaryTree q59PrintBinaryTree = new Q59PrintBinaryTree();
        System.out.println(Arrays.toString(q59PrintBinaryTree.print(tree).toArray()));
    }

}
