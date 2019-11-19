package com.zk.dji;


import java.util.Scanner;

public class Game {
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int nums = sc.nextInt();
        for (int i = 0; i < nums; i++) {
            int games = sc.nextInt();
            int times = sc.nextInt();
            sum = 0;
            int[] gTimes = new int[games];
            int[] values = new int[games];
            for (int j = 0; j < games; j++) {
                //成就值
                values[j] = sc.nextInt();
                //时间
                gTimes[j] = sc.nextInt();
            }
            game.preOrder(gTimes, values, 0, times, 0);
            System.out.println(sum);
        }
    }

    public void preOrder(int[] gTimes, int[] values, int index, int time, int currentSum) {
        //出口
        if (index >= gTimes.length) {
            sum = Math.max(sum, currentSum);
            return;
        }
        //剩余时间不足时，直接进入下一轮
        if (gTimes[index] > time){
            sum = Math.max(sum, currentSum);
            //不选择当前的
            preOrder(gTimes, values, index+1, time,currentSum);
            return;
        }
        //不选当前结点进行遍历
        preOrder(gTimes, values, index+1, time,currentSum);
        //选择当前结点进行遍历
        preOrder(gTimes, values, index+1, time-gTimes[index],currentSum+values[index]);
    }
}
