package com.zk.offer66;

import com.zk.offer66.from51to60.Q59PrintBinaryTree;

import java.util.ArrayList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(pRoot);
        Stack<TreeNode> stack = new Stack<>();
        boolean reverse = false;
        while(!q.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int c = q.size();
            if(!reverse){
                while(c > 0){
                    TreeNode node = q.poll();
                    temp.add(node.val);
                    if(node.right!=null){
                        q.add(node.right);
                    }
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    c--;
                }
                reverse = true;
            }else{
                while(c > 0){
                    TreeNode node = q.poll();
                    temp.add(node.val);
                    stack.push(node);
                    c--;
                }
                while(!stack.isEmpty()){
                    TreeNode node = stack.pop();
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
                reverse = false;
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] treeNode = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        TreeNode tree = TreeNode.buildTree(treeNode);
        Solution q59PrintBinaryTree = new Solution();
        System.out.println(Arrays.toString(q59PrintBinaryTree.print(tree).toArray()));
    }
}