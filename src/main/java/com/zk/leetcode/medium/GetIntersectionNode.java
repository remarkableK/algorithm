package com.zk.leetcode.medium;

import com.zk.offer66.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = getListLength(headA);
        int len2 = getListLength(headB);
        int dis = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (dis > 0) {
                headA = headA.next;
                dis--;
            }
        } else {
            while (dis > 0) {
                headB = headB.next;
                dis--;
            }
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getListLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * 转圈  将两个链表接在一起
     */
    public ListNode solution2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }
}
