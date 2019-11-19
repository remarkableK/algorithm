package com.zk.bytedance.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
public class Problem1 {
    public String solution(String str) {
        if (str.length() < 3) {
            return str;
        }
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        int index = 0;
        while (index <list.size() - 3) {
            if (list.get(index).equals(list.get(index + 1)) && (list.get(index + 1).equals(list.get(index + 2)))) {
                list.remove(index + 2);
                continue;
            } else if (list.get(index).equals(list.get(index + 1)) && (list.get(index + 2).equals(list.get(index + 3)))) {
                list.remove(index + 2);
                continue;
            }
            index++;
        }
        index = list.size();
        if ((list.get(index - 1).equals(list.get(index - 2))) && (list.get(index - 2).equals(list.get(index - 3)))) {
            list.remove(index - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Problem1 problem1 = new Problem1();
        int lines = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < lines; i++) {
            String str = sc.nextLine();
            System.out.println(problem1.solution(str));
        }

    }
}
