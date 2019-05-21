package com.zk.offer66.from11to20;

import java.util.Stack;

/**
 *定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author
 */
public class Q20_StackWithGetMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        if (minStack.size()==0){
            minStack.push(node);
        }else {
            int min = node < minStack.peek() ? minStack.push(node):minStack.push(minStack.peek());
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (minStack.size()!=0){
            return minStack.peek();
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Q20_StackWithGetMin stackWithGetMin = new Q20_StackWithGetMin();
        stackWithGetMin.push(3);
    }
}
