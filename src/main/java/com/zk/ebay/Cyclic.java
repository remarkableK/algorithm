package com.zk.ebay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cyclic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

    }

    public int min(char[] array){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i!=0){
                if (array[i] == array[0]){
                    boolean fit = true;
                    for (int j = 1; j < array.length; j++) {
                        if (array[j]!=list.get(j%list.size())){
                            fit = false;
                            break;
                        }
                    }
                    if (fit){
                        return list.size();
                    }
                }
            }
            list.add(array[i]);
        }
        return list.size();
    }
}
