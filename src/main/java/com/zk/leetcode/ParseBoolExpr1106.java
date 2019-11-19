package com.zk.leetcode;

import java.util.Stack;

public class ParseBoolExpr1106 {
    public static void main(String[] args) {
        ParseBoolExpr1106 p = new ParseBoolExpr1106();
        System.out.println(p.parseBoolExpr("!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))"));
    }

    public boolean parseBoolExpr(String str) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            //操作符
            if (current == ',') {
                continue;
            }
            if ((current == '!' || current == '|' || current == '&') && str.charAt(i + 1) == '(') {
                stack1.push(current);
            } else if (current == 't' || current == 'f' || current == '(') {
                stack2.push(current);
            } else if (current == ')') {
                char[] temp = new char[stack2.size()];
                char operator = ' ';
                int index = 0;
                //结束出栈
                while (!stack2.isEmpty() && stack2.peek() != '(') {
                    temp[index++] = stack2.pop();
                }
                //（ 出栈
                stack2.pop();
                if (!stack1.isEmpty()) {
                    operator = stack1.pop();
                }
                boolean res = calculate(operator, temp);
                if (res) {
                    stack2.push('t');
                } else {
                    stack2.push('f');
                }
            }
        }
        //最后还有
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            char[] chars = new char[stack2.size()];
            int index = 0;
            while (!stack2.isEmpty()) {
                chars[index++] = stack2.pop();
            }
            char o = ' ';
            if (!stack1.isEmpty()) {
                o = stack1.pop();
            } else {
                return chars[0] == 't';
            }

            boolean operate = calculate(o, chars);
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return operate;
            } else if (operate) {
                stack2.push('t');
            } else {
                stack2.push('f');
            }
        }
        return false;
    }

    public boolean calculate(char c, char[] array) {
        switch (c) {
            case '&':
                return and(array);
            case '|':
                return or(array);
            case '!':
                return not(array[0]);
            default:
                return false;
        }
    }

    /**
     * 非
     *
     * @param c
     * @return
     */
    public boolean not(char c) {
        return c != 't';
    }
    /**
     * 与
     *
     * @param chars
     * @return
     */
    public boolean and(char... chars) {
        for (char aChar : chars) {
            if (aChar == 'f') {
                return false;
            }
        }
        return true;
    }
    /**
     * 或
     *
     * @return
     */
    public boolean or(char... chars) {
        for (char aChar : chars) {
            if (aChar == 't') {
                return true;
            }
        }
        return false;
    }
}
