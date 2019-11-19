package com.zk.offer66.from41to50;

import java.util.HashSet;

public class Q50Duplicate {
    public boolean solution(int numbers[],int length,int [] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length ; i++) {
            if (!set.contains(numbers[i])){
                set.add(numbers[i]);
            }else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
