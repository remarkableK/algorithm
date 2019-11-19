package com.zk.yy;

import java.util.Scanner;

public class MiddleNode {
    static class Node {
        String val;
        Node next;

        public Node(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        Node head = new Node("-1");
        Node tail = head;
        for (int i = 0; i < strs.length; i++) {
            Node temp = new Node(strs[i]);
            tail.next = temp;
            tail = tail.next;
        }
        head = head.next;
        //快慢指针求中间值
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null){
            System.out.println(slow.val);

        }else {
            System.out.println(slow.next.val);
        }
    }
}
