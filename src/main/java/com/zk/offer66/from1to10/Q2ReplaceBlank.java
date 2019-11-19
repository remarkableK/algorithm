package com.zk.offer66.from1to10;

public class Q2ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        int p1 = len-1;
        while (p1 >= 0) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("A B C");
        Q2ReplaceBlank q2 = new Q2ReplaceBlank();
        System.out.println(q2.replaceSpace(sb));
    }
}
