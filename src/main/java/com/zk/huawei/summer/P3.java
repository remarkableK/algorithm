package com.zk.huawei.summer;

import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String begin = sc.nextLine();
        int groups = sc.nextInt();
        if (groups == 0){
            System.out.println(0);
        }else {
            HashMap<String, String> map = new HashMap<>();
            List<List<String>> lists = new ArrayList<>();
            for (int i = 0; i < groups; i++) {
                String[] persons = sc.next().split(",");
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < persons.length; j++) {
                    temp.add(persons[j]);
                    if (!map.containsKey(persons[j])) {
                        map.put(persons[j], String.valueOf(i));
                    } else {
                        map.put(persons[j], map.get(persons[j]) + "," + i);
                    }
                }
                lists.add(temp);
            }
            HashSet<String> resultSet = new HashSet<>();
            HashSet<Integer> processSet = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            //不处在任何群组
            if (!map.containsKey(begin)){
                System.out.println(0);
                return;
            }
            String first = map.get(begin);
            String[] firstGroup = first.split(",");
            for (int i = firstGroup.length - 1; i >= 0; i--) {
                stack.push(Integer.parseInt(firstGroup[i]));
            }
            while (!stack.isEmpty()) {
                //当前组已经处理过
                int g = stack.pop();
                processSet.add(g);
                List<String> currentGroup = lists.get(g);
                for (String s : currentGroup
                ) {
                    resultSet.add(s);
                    //将当前组的标记为要处理，可以优化
                    String[] cGroup = map.get(s).split(",");
                    for (int i = cGroup.length-1; i >=0 ; i--) {
                        //处理过的群组不再处理
                        if (!processSet.contains(Integer.parseInt(cGroup[i]))) {
                            stack.push(Integer.parseInt(cGroup[i]));
                        }
                    }
                }
            }
            System.out.print(resultSet.size());
        }
    }
}
