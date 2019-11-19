package com.zk.bytedance.spring;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCompare {

    public static String solution(String str) {
        if (str.length() < 3) {
            return str;
        }
        if (str.length() == 3) {
            if (str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) {
                return str.substring(0, 2);
            } else {
                return str;
            }
        }
        int index = 0;
        char[] array = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        while (index <= list.size() - 3) {
            //AAAX
            if (list.get(index).equals(list.get(index + 1)) && list.get(index + 1).equals(list.get(index + 2))) {
                list.remove(index + 2);
                continue;
            }
            //xAAA
            if (list.get(index+2) .equals(list.get(index+1))  &&list.get(index+2).equals(list.get(index+3))) {
                list.remove(index+2);
                continue;
            }
            //AABB
            if (list.get(index).equals(list.get(index + 1)) && list.get(index + 2).equals(list.get(index + 3))) {
                list.remove(index + 2);
                continue;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] strings = new String[num];
        int index = 0;
        while (num > 0){
            strings[index++] = sc.nextLine();
            num--;
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(AutoCompare.solution(strings[i]));
        }
//
    }
}
