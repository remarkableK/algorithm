package com.zk.huawei.summer;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String out = "";
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String s = s1 + s1;
            if(s.indexOf(s2) != -1)
                out += 1;
            else
                out += 0;
        }
        System.out.println(out);
    }
}
