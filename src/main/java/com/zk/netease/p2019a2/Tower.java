package com.zk.netease.p2019a2;

import java.util.*;

public class Tower {
    static class Tow {
        int index;
        int h;

        public Tow(int index, int h) {
            this.index = index;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Tow> maxQueue = new PriorityQueue<>(new Comparator<Tow>() {
            @Override
            public int compare(Tow o1, Tow o2) {
                return o2.h - o1.h;
            }
        });
        PriorityQueue<Tow> minQueue = new PriorityQueue<>(new Comparator<Tow>() {
            @Override
            public int compare(Tow o1, Tow o2) {
                return o1.h - o2.h;
            }
        });
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            Tow tow = new Tow(i + 1, height);
            maxQueue.add(tow);
            minQueue.add(tow);
        }
        int times = 0;
        List<Integer> res = new ArrayList<>();
        int dis = 0;
        while (times < k) {
            dis = maxQueue.peek().h - minQueue.peek().h;

            if (dis == 0) {
                break;
            }
            Tow max = maxQueue.poll();
            Tow min = minQueue.poll();
            min.h++;
            max.h--;
            res.add(max.index);
            res.add(min.index);
            maxQueue.add(max);
            minQueue.add(min);
            times++;
        }
        dis = maxQueue.peek().h - minQueue.peek().h;
        System.out.println(dis + " " + times);
        for (int i = 0; i < res.size(); i = i + 2) {
            System.out.println(res.get(i) + " " + res.get(i + 1));
        }
    }
}
