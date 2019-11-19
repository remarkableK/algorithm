package com.zk.offer66.from21to30;

import com.zk.offer66.RandomListNode;

/**
 * 复杂链表复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Q25_RandomListNodeClone implements Cloneable{
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        RandomListNode result = new RandomListNode(pHead.label);
        RandomListNode resultTemp = result;
        RandomListNode temp = pHead.next;
        //先如复制一遍
        while (temp !=null){
            resultTemp.next  = new RandomListNode(temp.label);
            temp = temp.next;
            resultTemp = resultTemp.next;
        }
        //为random复制
        resultTemp = result;
        temp = pHead;
        while (resultTemp!=null){
            //下个随机结点的值
            int value = temp.random.label;
            RandomListNode find = result;
            while (find!=null){
                if (find.label == value){
                    resultTemp.random = find;
                    break;
                }
                find = find.next;
            }
            resultTemp = resultTemp.next;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
