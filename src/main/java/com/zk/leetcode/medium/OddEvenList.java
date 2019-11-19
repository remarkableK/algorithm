package com.zk.leetcode.medium;
import com.zk.offer66.ListNode;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode arrow = even.next;
        boolean oddFlag = true;
        while (arrow != null) {
            if (oddFlag) {
                odd.next = arrow;
                odd = odd.next;
            } else {
                even.next = arrow;
                even = even.next;
            }
            oddFlag = !oddFlag;
            arrow = arrow.next;
        }
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5};
        ListNode l1 = new ListNode(a1);
        OddEvenList o = new OddEvenList();
        System.out.println(o.oddEvenList(l1).toString());
    }
}
