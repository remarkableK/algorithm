package com.zk.sina;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字符串版本号比较
 */
public class Version {
    public String getMinVersion(String[] list) {
        // 在这里编写代码
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split("\\.");
                String[] s2 = o2.split("\\.");
                int l1 = s1.length, l2 = s2.length;
                int i = 0, j = 0;
                for (i = 0, j = 0; i < l1 && j < l2; i++, j++) {
                    if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[j])) {
                        return 1;
                    } else if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[j])) {
                        return -1;
                    }
                }
                while (i < l1) {
                    if (Integer.parseInt(s1[i])!=0){
                        return 1;
                    }
                    i++;
                }
                while (j < l2) {
                    if (Integer.parseInt(s2[j])!=0){
                        return -1;
                    }
                    j++;
                }
                return 0;
            }
        });
        return list[0];
    }

    public static void main(String[] args) {
        String[] list = {"3", "4.3.5.4", "2.10.3", "2.4"};
        Version version = new Version();
        System.out.println(version.getMinVersion(list));
    }
}
