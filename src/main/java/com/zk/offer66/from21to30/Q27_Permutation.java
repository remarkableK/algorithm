package com.zk.offer66.from21to30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Q27_Permutation {
    /**
     * https://blog.csdn.net/u013132035/article/details/80639439
     * @param str
     * @return
     */
    public ArrayList<String> solution(String str){
        if (str == null){
            return null;
        }
        if (str.length() == 0){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        permutation(str.toCharArray(),0,result);
        //去重复
        HashSet<String> set = new HashSet<>(result);
        String[] strings = (String[]) set.toArray(new String[set.size()]);
        Arrays.sort(strings);
        return new ArrayList<>(Arrays.asList(strings));
    }

    private void permutation(char[] charArray, int position,ArrayList<String> result) {
        if (position == charArray.length - 1){
            StringBuilder sb = new StringBuilder();
            for (char c : charArray) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = position; i < charArray.length; i++) {
            //将当前元素依次与它后面的元素交换 包括和自己
            char temp = charArray[i];
            charArray[i] =  charArray[position];
            charArray[position] = temp;
            permutation(charArray,position+1,result);
            //因为交换过所有要恢复为原来的序列
            temp = charArray[i];
            charArray[i] =  charArray[position];
            charArray[position] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        Q27_Permutation q  = new Q27_Permutation();
        ArrayList<String> result = q.solution(s);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
