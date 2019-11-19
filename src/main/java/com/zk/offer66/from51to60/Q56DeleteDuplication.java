package com.zk.offer66.from51to60;

import com.zk.offer66.ListNode;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Q56DeleteDuplication {
    /**
     * 递归
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next != null) {
            if (pHead.val != pHead.next.val) {
                //
                pHead.next = deleteDuplication(pHead.next);
                return pHead;
            } else {
                ListNode temp = pHead.next;
                while (temp != null && temp.val==pHead.val){
                    temp = temp.next;
                }
                //有重复的
                return deleteDuplication(temp);
            }
        } else {
            return pHead;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,3,4,4,5};
        ListNode listNode = new ListNode(array);
        Q56DeleteDuplication q56 = new Q56DeleteDuplication();
        listNode = q56.deleteDuplication(listNode);
        System.out.println(listNode.toString());
    }
}
