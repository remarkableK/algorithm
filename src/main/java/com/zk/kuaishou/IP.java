package com.zk.kuaishou;

import java.util.Scanner;

public class IP {
    public static void main(String[] args) {
        IP ip = new IP();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(ip.valid(s));
    }

    private String valid(String ipStr) {
        if (ipStr == null || ipStr.length() == 0) {
            return "Neither";
        }
        boolean illegal = ipStr.startsWith(".") || ipStr.endsWith(".") || ipStr.startsWith(":") || ipStr.endsWith(":");
        if (illegal) {
            return "Neither";
        }
        String[] strs = ipStr.split("\\.");
        if (strs.length == 4) {
            int num = -1;
            for (int i = 0; i < 4; i++) {
                try {
                    num = Integer.parseInt(strs[i]);
                } catch (Exception e) {
                    return "Neither";
                }
                if (num < 0 || num > 255) {
                    return "Neither";
                }
                if (strs[i].length() > 1 && (strs[i].startsWith("0") || strs[i].startsWith("00")
                        || strs[i].startsWith("000")|| strs[i].startsWith("0000")||strs[i].startsWith("-"))) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            strs = ipStr.split(":");
            if (strs.length == 8) {
                long num = -1;
                for (int i = 0; i < 8; i++) {

                    if (strs[i].length() > 4 || strs[i].startsWith("-")) {
                        return "Neither";
                    }
                    try {
                        num = Long.parseLong(strs[i], 16);
                    } catch (Exception e) {
                        return "Neither";
                    }
                    if (num < 0 ) {
                        return "Neither";
                    }
                    if ( strs[i].length() > 1 && (strs[i].startsWith("0") || strs[i].startsWith("00")
                            || strs[i].startsWith("000")|| strs[i].startsWith("0000")||strs[i].startsWith("-"))){
                        return "Neither";
                    }
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }
}
