package com.zk.offer66.from1to10;

import com.zk.offer66.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Q3_PrintListFromTailToHead {
    /**
     * 用栈 时间复杂度0(n),空间复杂度0(n)
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 先翻转后添加 ，时间复杂度0(n),空间复杂度0(1)
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> solution2(ListNode listNode) {
        ListNode newHead = reverseNoRecursion(listNode);
        ArrayList<Integer> result = new ArrayList<>();
        while (newHead != null) {
            result.add(newHead.val);
            newHead = newHead.next;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        ListNode listNode = new ListNode(values);
        Q3_PrintListFromTailToHead q3 = new Q3_PrintListFromTailToHead();
        ArrayList<Integer> res = q3.solution2(listNode);
        System.out.println(Arrays.toString(res.toArray()));
    }


    /**
     * 递归的翻转链表
     *
     * @param listNode
     * @return
     */
    private ListNode reverseRecursion(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode newHead = reverseRecursion(listNode.next);
        //  翻转
        ListNode nextNode = listNode.next;
        nextNode.next = listNode;
        listNode.next = null;
        return newHead;
    }

    /**
     * 非递归的翻转链表 .......
     * 第二遍，用头差法
     *
     * @param listNode
     * @return
     */
    private ListNode reverseNoRecursion(ListNode listNode) {
        ListNode res = null;
        while (listNode != null) {
            ListNode temp =listNode;
            listNode = listNode.next;
            //头插
            temp.next = res;
            res = temp;
        }
        return res;
    }
}
