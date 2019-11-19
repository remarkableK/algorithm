package com.zk.yy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MergeListYouZan {

    /**
     * 合并两个排序的链表
     */
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
        while (list1 != null && list1.val == head.val) {
            list1 = list1.next;
        }
        while (list2 != null && list2.val == head.val) {
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
            while (list1 != null && head.val == list1.val) {
                list1 = list1.next;
            }
            head.next = list1;
        }
        if (list2 != null) {
            while (list2 != null && head.val == list2.val) {
                list2 = list2.next;
            }
            head.next = list2;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.trim().length() == 0) {
            System.out.println("");
            return;
        }
        String[] strs = s.split("\\|");
        String[] list1 = strs[0].split(",");
        HashSet<Integer> set = new HashSet<>();
        if (list1.length > 0) {
            for (String x:list1
                 ) {
                set.add(Integer.parseInt(x));
            }
        }
        if (strs.length > 1 && strs[0].length() > 0){
            String[] list2 = strs[1].split(",");
            for (String x:list2
                 ) {
                set.add(Integer.parseInt(x));
            }
        }
        String[] nums = new String[set.size()];
        int index = 0;
        for (Object x:set.toArray()
             ) {
            nums[index] = (String) x;
            index++;
        }
        Arrays.sort(nums);
        ListNode l1 = new ListNode(nums);
        //[1, 2, 3, 4, 6, 7]
        StringBuilder sb = new StringBuilder("[");
        while (l1 != null) {
            sb.append(l1.val).append(", ");
            l1 = l1.next;
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
            if (values == null || values.length == 0) {
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
