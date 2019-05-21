package com.zk.offer66.from11to20;

import com.zk.offer66.ListNode;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * easy
 */
public class Q15_ReverseList {
    /**
     * 第一种递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next == null){
            return head;
        }
        //找到最后一个结点
        ListNode reverseHead = reverseList(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        //返回最后一个
        return reverseHead;
    }
    /**
     * 非递归
     */
    public static ListNode reverseList2(ListNode head) {
        if (head==null||head.next == null){
            return head;
        }
        ListNode newHead = head;
        head = head.next;
        //在这里浪费了一点时间，不置空的话，会造成循环引用
        newHead.next = null;
        while (head!=null){
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;

        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,4,5,6};
        ListNode node = new ListNode(values);
        ListNode result = Q15_ReverseList.reverseList2(node);
        System.out.println(result);
    }
}
