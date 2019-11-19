package com.zk.xiecheng;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 表达式求值
 */
public class P2_Expression {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
((ur)(wa)(oi))  iour
******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        //左括号出现的次数
        int leftNum = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                stack.push(expr.charAt(i));
                leftNum++;
            } else if (expr.charAt(i) != ')') {
                stack.push(expr.charAt(i));
            } else {
                if (leftNum < 1) {
                    return "";
                }
                //取出来所有的字母
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String s = sb.toString();
                //再放进去 完成一次逆转
                for (int j = 0; j < s.length(); j++) {
                    stack.push(s.charAt(j));
                }
                leftNum--;

            }
        }
        if (leftNum != 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        //逆转输出
        return res.reverse().toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
