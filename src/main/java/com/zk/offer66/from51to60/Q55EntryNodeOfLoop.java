package com.zk.offer66.from51to60;

import com.zk.offer66.ListNode;



/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class Q55EntryNodeOfLoop {
    /**
     *解题思路 fast slow 快慢指针
     * 假设存在环 ,设从链表开始到环的入口的距离为x
     * 环周长为c  fast 和solo 相遇的位置距离环的入口的距离为a
     * fast走的路程为s1 = x + m*c +a m圈
     * slow走的路程为s1 = x + n*c +a
     * s1 = s2*2    x + m*c +a = 2*(x + n*c +a) 整理得 x = (n-2m)*c - a =  = (n-2m-1)*c + c - a
     * c-a 即为相遇点到环入口的距离， 于是一个从head出发，一个从相遇点出发，一直走，直到二者相遇便是入口
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //不存在环
                return null;
            }
        }
        //存在环
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
