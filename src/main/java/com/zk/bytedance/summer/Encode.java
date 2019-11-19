package com.zk.bytedance.summer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Encode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<>();
        Encode encode = new Encode();
        String cur = "";
        encode.dfs(str.toCharArray(), 0, list, cur);
        for (String s:list
             ) {
            System.out.println(s);
        }
    }

    HashMap<Integer, Character> map = new HashMap<>(32);

    {
        int index = 0;
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) ('A' + index));
            index++;
        }
    }

    private void dfs(char[] chars, int index, List<String> list, String cur) {
        if (index >= chars.length) {
            list.add(cur);
            return;
        }
        //加入当前字符
        if (chars[index] > '0' && chars[index] <= '9') {
            //拼接
            String temp = cur + map.get(chars[index] - '0');
            dfs(chars, index + 1, list, temp);
        }
        //和后面的关联，看看否加入
        if (chars[index] >= '1' && chars[index] <= '2' && index + 1 < chars.length) {
            if (chars[index] == '1') {
                int nums = 10 + (chars[index + 1] - '0');
                cur = cur + map.get(nums);
                dfs(chars, index + 2, list, cur);
            } else if (chars[index] == '2' && chars[index+1] <= '6') {
                int nums = 20 + (chars[index + 1] - '0');
                cur = cur + map.get(nums);
                dfs(chars, index + 2, list, cur);
            }
        }
    }
}
