package com.zk.offer66.from11to20;


import java.util.List;
import java.util.Scanner;

/**
 * 合并两个排序的链表
 */
public class MergeList {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list2.val >= list1.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else if (list1.val == list2.val) {
                head.next = list1;
                list1 = list1.next;
                list2 = list2.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            while (  list1!=null&&head.val == list1.val){
                list1 = list1.next;
            }
            head.next = list1;
        }
        if (list2 != null) {
            while (list2!=null&&head.val == list2.val ){
                list2 = list2.next;
            }
            head.next = list2;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.trim().length() == 0){
            System.out.println("");
            return;
        }
        String[] strs = s.split("\\|");
        String[] list1 = strs[0].split(",");
        ListNode l1 = new ListNode(list1);
        ListNode l2;
        String[] list2;
        if (strs.length == 1) {
            l2 = null;
        } else {
            list2 = strs[1].split(",");
            l2 = new ListNode(list2);

        }

        MergeList mergeList = new MergeList();
        ListNode res = mergeList.merge(l1, l2);
        //[1, 2, 3, 4, 6, 7]
        StringBuilder sb = new StringBuilder("[");
        while (res != null) {
            sb.append(res.val).append(", ");
            res = res.next;
        }
        String temp = sb.toString().trim();
        System.out.println(temp.substring(0, temp.length() - 1) + "]");
    }

    static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(String[] values) {
            if (values == null) {
                return;
            }
            this.val = Integer.parseInt(values[0]);
            ListNode arrow = this;
            for (int i = 1; i < values.length; i++) {
                ListNode t = new ListNode(Integer.parseInt(values[i]));
                arrow.next = t;
                arrow = arrow.next;
            }
        }
    }
}
