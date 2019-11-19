package com.zk.leetcode.medium.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LetterCombinations1 {
    String[] format = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String temp = "";
        preOrder(digits, 0, res, temp);
        return res;
    }

    /**
     * dfs构造树去前序遍历
     * @param digits
     * @param i
     * @param res
     * @param temp 存储前面的结果
     */
    public void preOrder(String digits, int i, List<String> res, String temp) {
        if (i == digits.length()) {
            res.add(temp);
            return;
        }
        int len = format[digits.charAt(i) - '0'].length();
        for (int j = 0; j < len; j++) {
            String temp1 = temp+ format[digits.charAt(i) - '0'].charAt(j);
            preOrder(digits, i + 1, res, temp1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations1 le = new LetterCombinations1();
        Scanner sc = new Scanner(System.in);
        List<String> res = le.letterCombinations(sc.next());
        System.out.println(Arrays.toString(res.toArray()));
    }
}
