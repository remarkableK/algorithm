package com.zk.yuanfudao;

import com.zk.offer66.TreeNode;

import java.util.*;

/**
 * 二叉树的垂直遍历
 *
 * @author 95620
 */
public class BinaryVerticalOrder {
    class Node{
        TreeNode node;
        int index;

        public Node(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    /**
     * 使用TreeMap 进行排序 key下标位置，value为值
     * root的index=0 左子树减一 右子树加一 其余节点相同
     * 进行层次遍历
     * @param root
     * @return
     */
    public List<Integer> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0));
        //每次加入两个值 一个是节点值 一个是下标
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur.index)){
                map.put(cur.index,cur.node.val);
            }
            if (cur.node.left!=null){
                queue.add(new Node(cur.node.left,cur.index-1));
            }
            if (cur.node.right!=null){
                queue.add(new Node(cur.node.right,cur.index+1));
            }
        }
        for (int index:map.keySet()
             ) {
            result.add(map.get(index));
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTree(nums);
        root.right.right.right = new TreeNode(9);
        BinaryVerticalOrder binaryVerticalOrder = new BinaryVerticalOrder();
        System.out.println(Arrays.toString(binaryVerticalOrder.verticalOrder(root).toArray()));
    }
}
