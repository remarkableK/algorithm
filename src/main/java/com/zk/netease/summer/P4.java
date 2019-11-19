package com.zk.netease.summer;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class P4 {
    static class Obj {
        int num;
        int times;

        public Obj(int num, int times) {
            this.num = num;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] query = new int[k];
        int[] nums = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Obj> queue = new PriorityQueue<>(new Comparator<Obj>() {
            @Override
            public int compare(Obj o1, Obj o2) {
                return o2.num - o1.num;
            }
        });
        for (int x : map.keySet()
        ) {
            Obj temp = new Obj(x, map.get(x));
            queue.add(temp);
        }
        for (int i = 0; i < k; i++) {
            query[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int times = 0;
            Obj t = queue.peek();
            while (t != null && t.num >= query[i]) {
                Obj cur = queue.poll();
                times += cur.times;
                cur.num = cur.num - 1;
                t = queue.peek();
                if (t != null && t.num == cur.num) {
                    int cTimes = cur.times;
                    cur = queue.poll();
                    cur.times = cTimes + cur.times;
                }
                queue.add(cur);
                t = queue.peek();
                if (queue.size() ==1){
                    break;
                }
            }
            System.out.println(times);
        }
    }
}
