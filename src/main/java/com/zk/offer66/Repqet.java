package com.zk.offer66;

public class Repqet {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 5};
        ListNode listNode = new ListNode(a);
        Repqet q = new Repqet();
        System.out.println(q.deleteDuplication1(listNode));
    }

    /**
     * 非递归版本
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //新建一个头
        ListNode head = new ListNode(Integer.MAX_VALUE);
        head.next = pHead;
        //表示结果集的尾指针
        ListNode pre = head;
        while (pHead != null) {
            if (pHead.next != null && pHead.val == pHead.next.val) {
                //找到最后一个不重复的
                while (pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                //跳过所有重复的
                pre.next = pHead.next;
                pHead = pHead.next;
            } else {
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return head.next;
    }

    /**
     * 递归版
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pre = pHead;
        boolean change = false;
        if (pHead.next.val == pHead.val) {
            while (pHead.next != null && pHead.next.val == pHead.val) {
                pHead = pHead.next;
                change = true;
            }
        }
        if (change && pre.val == pHead.val) {
            return deleteDuplication1(pHead.next);
        } else if (!change){
            pre.next = deleteDuplication1(pHead.next);
        }
        return pHead;
    }
}
