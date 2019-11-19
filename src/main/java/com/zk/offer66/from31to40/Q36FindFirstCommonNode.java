package com.zk.offer66.from31to40;

import com.zk.offer66.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Q36FindFirstCommonNode {
    /**
     * 第一种方法，使用HashSet
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode solution(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode t1 = pHead1;
        ListNode t2 = pHead2;
        HashSet<Integer> set = new HashSet<>();
        while (t1 != null) {
            set.add(t1.val);
            t1 = t1.next;
        }
        while (t2 != null) {
            if (set.contains(t2.val)) {
                return t2;
            }
            t2 = t2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {7, 1, 2, 8, 9};
        ListNode l1 = new ListNode(array1);
        ListNode l2 = new ListNode(array2);
        Q36FindFirstCommonNode q36 = new Q36FindFirstCommonNode();
        ListNode result = q36.solution(l1, l2);
        System.out.println(result.val);
    }


    /**
     * 解法2
     * 两个链表有公共结点必然会粘在一起，
     * 分别遍历两个链表，求出长度，然后，一个指针先走长度之差
     * 然后两个指针同时走比较值的大小
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode longHead;
        ListNode shortHead;
        if (len1 > len2) {
            longHead = pHead1;
            shortHead = pHead2;
        } else {
            longHead = pHead2;
            shortHead = pHead1;
        }
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null) {
            if (longHead.val == shortHead.val){
                return longHead;
            }else {
                longHead = longHead.next;
                shortHead = shortHead.next;
            }
        }
        return null;
    }


    public int getLength(ListNode head) {
        int len = 0;
        ListNode temp=head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

}
