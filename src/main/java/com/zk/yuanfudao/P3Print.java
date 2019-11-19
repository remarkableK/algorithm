package com.zk.yuanfudao;


import java.util.*;
import java.util.stream.Stream;

public class P3Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            list.add(s);
            if (System.currentTimeMillis() - begin > 500){
                break;
            }
        }
        String[] arrays = (String[]) list.toArray();
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}