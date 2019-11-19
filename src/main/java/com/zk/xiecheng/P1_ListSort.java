package com.zk.xiecheng;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class P1_ListSort {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode low = new ListNode(-1);
        ListNode lArrow = low;
        ListNode high = new ListNode(-1);
        ListNode hArrow = high;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            if (temp.val <= m) {
                lArrow.next = temp;
                lArrow = lArrow.next;
            } else {
                hArrow.next = temp;
                hArrow = hArrow.next;
            }
        }
        lArrow.next = null;
        hArrow.next = null;
        if (low.next != null && high.next != null) {
            lArrow.next = high.next;
            return low.next;
        }
        if (low.next == null) {
            return high.next;
        }
        return low.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        int t = 2;
        while (t > 0) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
            t--;
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
