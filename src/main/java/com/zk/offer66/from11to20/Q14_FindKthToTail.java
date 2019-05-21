package com.zk.offer66.from11to20;

import com.zk.offer66.ListNode;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * easy题。。。只是要规避一些边界情况就好了
 */
public class Q14_FindKthToTail {
    /**
     * 解题思路双指针
     * 时间复杂度 O(n)
     * 空间复杂度O(1)
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null|| head.next == null){
            return head;
        }
        //倒数第0个
        if (k == 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        int step = 0;
        while (first.next!=null && step != k-1){
            first = first.next;
            step++;
        }
        //k比链表的总长度大
        if (step < k-1){
            return null;
        }
        while (first.next!=null){
            first = first.next;
            second= second.next;
        }
        return second;
    }
}
