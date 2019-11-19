package com.zk.recursion;

import java.util.Arrays;

/**
 * 字符串全排列
 */
public class Permutation {
    public void solution(char[] array) {
        permutation1(array, 0);
    }

    public void permutation1(char[] array, int position) {
        if (position == array.length - 1) {
            System.out.println(Arrays.toString(array));
        }

        for (int i = position; i < array.length; i++) {
            char temp = array[position];
            array[position] = array[i];
            array[i] = temp;
            permutation1(array, position + 1);
            temp = array[position];
            array[position] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        String[] str = {"abc","dba","cbd"};
        Permutation p = new Permutation();
        System.out.println(p.strPermution(str,0));;
    }

    public boolean strPermution(String[] strs, int position) {
        if (position >= strs.length) {
            String str1 = strs[0];
            String str2 = strs[strs.length - 1];
            System.out.println(Arrays.toString(strs));
            return str1.charAt(0) == str2.charAt(str2.length() - 1);
        }
        for (int i = position; i < strs.length; i++) {
            String temp = strs[position];
            strs[position] = strs[i];
            strs[i] = temp;
            boolean res = strPermution(strs, position + 1);
            if (res){
                return true;
            }
            temp = strs[position];
            strs[position] = strs[i];
            strs[i] = temp;
        }
        return  false;
    }
}
