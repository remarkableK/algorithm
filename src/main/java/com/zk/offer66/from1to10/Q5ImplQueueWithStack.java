package com.zk.offer66.from1to10;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Q5ImplQueueWithStack {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    /**
     * 入队存储到in
     * 出队从out出，out为空的时候将in中的所有元素pop至out
     * @param node
     */
    public void push(int node) {
        in.push(node);
    }

    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
