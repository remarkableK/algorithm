package com.zk.offer66.from41to50;


public class Q44ReverseSentence {
    public String solution(String str) {
        if (str == null || str.length() <=1 || str.trim().length() ==0){
            return str;
        }
        String[] array = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length-1; i > 0 ; i--) {
            sb.append(array[i]).append(" ");
        }
        sb.append(array[0]);
        return sb.toString();
    }
}
