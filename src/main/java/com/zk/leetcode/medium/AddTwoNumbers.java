package com.zk.leetcode.medium;

import com.zk.offer66.ListNode;

/**
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode arrow = new ListNode(Integer.MAX_VALUE);
        ListNode list = arrow;

        int flag = 0;
        while (l1 != null && l2 != null) {
            int current = l1.val + l2.val + flag;
            if (current >= 10) {
                arrow.next = new ListNode(current % 10);
                flag = 1;
            } else {
                arrow.next = new ListNode(current);
                flag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            arrow = arrow.next;
        }
        while (l1 != null) {
            int c = l1.val + flag;
            if (c >= 10) {
                arrow.next = new ListNode(c % 10);
                flag = 1;
            }else {
                arrow.next = new ListNode(c);
                flag = 0;
            }
            l1 = l1.next;
            arrow = arrow.next;
        }
        while (l2 != null) {
            int c = l2.val + flag;
            if (c >= 10) {
                arrow.next = new ListNode(c % 10);
                flag = 1;
            }else {
                arrow.next = new ListNode(c);
                flag = 0;
            }
            l2 = l2.next;
            arrow = arrow.next;
        }
        if (flag == 1){
            arrow.next = new ListNode(1);
        }
        return list.next;
    }

    public static void main(String[] args) {
        int[] a1 = {5};
        ListNode l1 = new ListNode(a1);
        int[] a2 = {5};
        ListNode l2 = new ListNode(a2);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(l1,l2).toString());
    }
}
