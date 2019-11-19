package com.zk.offer66;

/**
 * 链表节点
 *
 * @author
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }



    public ListNode(int[] values) {
        this.val = values[0];
        ListNode arrow = this;
        for (int i = 1; i < values.length; i++) {
            ListNode t = new ListNode(values[i]);
            arrow.next = t;
            arrow = arrow.next;
        }
    }

    @Override
    public String toString() {
        ListNode listNode = this;
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
}
