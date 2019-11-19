package com.zk.cisco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replace("\"", "");
        if (s.contains("<sip") && s.contains(">")) {
            int index1 = s.indexOf("<sip");
            int index2 = s.indexOf(">");
            String temp = "";
            if (index2 == s.length() - 1 && !s.contains("%22")) {
                System.out.println(s.substring(0, index1));
                return;
            } else {
                temp = s.substring(0, index1);
            }
            if ("".equals(temp) || ";".equals(temp)) {
                System.out.println("");
            } else {
                if (temp.startsWith("%22") && temp.startsWith("%22")) {
                    System.out.println(temp.substring(3, temp.length() - 3));
                } else {
                    System.out.println(temp);
                }
            }
        }
    }
}
//"%22Ci%22sco%22"<sip:10000@172.16.130.42>