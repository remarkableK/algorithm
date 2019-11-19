package com.zk.dji;

import java.util.HashMap;
import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String first =sc.nextLine();
            //对数
            int n = Integer.parseInt(first.split(" ")[0]);
            //调试的指令数目
            int m = Integer.parseInt(first.split(" ")[1]);
            HashMap<String,String> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                String[] strs = s.split(" ");
                map.put(strs[0],strs[1]);
            }
            for (int i = 0; i < m; i++) {
                String cmd = sc.nextLine();
                System.out.println(map.get(cmd));
            }
        }
    }
}
