package com.zk.weicelue;

import com.zk.xiecheng.P1_ListSort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class KuHao {


    // Complete the braces function below.
    static List<String> braces(List<String> values) {
        List<String> result = new ArrayList<>();
        for (String str : values
        ) {

            if (str.length() % 2 == 1) {
                result.add("NO");
            } else {
                Stack<Character>   stack = new Stack<>();
                for (int i = 0; i < str.length(); i++) {
                    if (stack.isEmpty()) {
                        stack.push(str.charAt(i));
                    } else if ((stack.peek() == '[' && str.charAt(i) == ']')
                            || (stack.peek() == '(' && str.charAt(i) == ')')
                            || (stack.peek() == '{' && str.charAt(i) == '}')) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
                if (stack.isEmpty()) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        List<String> res = KuHao.braces(list);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
