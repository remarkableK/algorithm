package com.zk.offer66.from51to60;

import java.util.Scanner;

public class Q54FirstNoRepeatChar {
    int[] ascii = new int[256];
    String s="";

    public void Insert(char ch) {
        ascii[ch]++;
        s += ch;
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < s.length(); i++) {
            if (ascii[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Q54FirstNoRepeatChar q = new Q54FirstNoRepeatChar();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            q.Insert(sc.nextLine().charAt(0));
            System.out.println(q.FirstAppearingOnce());
        }
    }
}
