package com.zk.offer66.from61to66;

import com.zk.offer66.TreeNode;


public class Q61SerializeThree {
    /**
     * 层次遍历 空结点用#
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seralizeSolution(root, sb);
        String temp = sb.toString();
        return temp.substring(0, temp.length() - 1);
    }

    public void seralizeSolution(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        seralizeSolution(root.left, sb);
        seralizeSolution(root.right, sb);
    }
    int index = -1;
    public TreeNode deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] array = str.split(",");
        return buildTree(array);
    }

    public TreeNode buildTree(String[] str) {
        if (!"#".equals(str[++index])) {
            TreeNode treeNode = new TreeNode(Integer.parseInt(str[index]));
            treeNode.left = buildTree(str);
            treeNode.right = buildTree(str);
            return treeNode;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = TreeNode.buildTree(root);
        Q61SerializeThree q61 = new Q61SerializeThree();
        String sert = q61.serialize(treeNode);
        System.out.println(sert);
        TreeNode t = q61.deserialize(sert);
        System.out.println(t.toString());
    }
}
