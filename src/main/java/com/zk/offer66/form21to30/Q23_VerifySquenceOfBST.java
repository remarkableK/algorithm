package com.zk.offer66.form21to30;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Q23_VerifySquenceOfBST {
    public static   boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length < 1){
            return false;
        }
        return subSoultion(sequence,0,sequence.length-1);
    }

    /**
     * 本组序列的最后一个数字即是该二叉排序树的根节点
     * 从左到右，第一个大于根节点的数字就是其右子树开始的位置，第一个小于头结点的是其左子树开始位置
     */
    public static   boolean subSoultion(int[] subSeq,int left,int right){
        //递归的出口
        if (left>=right){
            return true;
        }
        int head = subSeq[right];
//        int firstSmallIndex = left;
        int firstBigIndex = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            //找到第一个大于head的
            if (subSeq[i] > head){
                firstBigIndex = i;
                break;
            }
        }
        //只有左子树的特殊情况是OK的
        if (firstBigIndex > right){
            return true;
        }
        //验证一些firstBigIndex -> firstSmallIndex是否都比 head 大， 肯定是这样，跳过
        //验证一些firstSmallIndex ->right-1是否都比 head 小，
        for (int i = firstBigIndex+1; i < right; i++) {
            if (subSeq[i] < head){
                return false;
            }
        }
        //递归验证其左右子树
        return subSoultion(subSeq,left,firstBigIndex-1)&&subSoultion(subSeq,firstBigIndex,right-1);
    }

    public static void main(String[] args) {
        int[] seq = {1,2,3,4,5};
        System.out.println(verifySquenceOfBST(seq));
    }
}
