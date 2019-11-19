package com.zk.offer66.others;

/**
 * 复杂链表复制
 */
public class CopyList {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode temp = pHead;
        //插入结点
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        //建立random连接
        temp = pHead;
        RandomListNode flag = temp.next;
        while (temp != null) {
            flag = temp.next;
            if (temp.random != null) {
                flag.random = temp.random.next;
            }
            temp = flag.next;
        }
        //分开
        RandomListNode res = pHead.next;
        temp = pHead;
        while (temp.next != null) {
            RandomListNode next = temp.next;
            temp.next = next.next;
            temp = next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        head.next = second;
        second.next = three;
        head.random = three;
        three.random = second;
        second.random = head;
        CopyList copyList = new CopyList();
        RandomListNode res = copyList.clone(head);
        System.out.println(res);
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
