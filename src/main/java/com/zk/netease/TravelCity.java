package com.zk.netease;

import java.util.Scanner;

/**
 * 题目链接:https://www.nowcoder.com/profile/2973094/test/24583938/126951#summary
 * 题解链接:https://www.jianshu.com/p/0f735ec650d1
 */
public class TravelCity {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String[] charArray = line1.split(" ");
            int cityNumber = Integer.parseInt(charArray[0]);
            int steps = Integer.parseInt(charArray[1]);
            String[] parents = line2.split(" ");
            int[] dp = new int[100];
            int max = 0;
            for (int i = 0; i < cityNumber - 1; i++) {
                //当前结点的深度
                dp[i+1] = dp[Integer.parseInt(parents[i])]+1;
                max = Math.max(max,dp[i+1]);
            }
            int result = 0;
            //当行动次数<树深时,可以游历的最多城市数量=行动次数+1
            if (steps < max){
                result = steps + 1;
            }else if ((max + (steps - max)/2 + 1) > cityNumber){
                //当能走的大于 城市数
                result = cityNumber;
            }else {
                // 最大的分支 出去走这个单支
                result = (max + (steps - max)/2 + 1);
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        TravelCity travelCity = new TravelCity();
        travelCity.solution();
    }
}
