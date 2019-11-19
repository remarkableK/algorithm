package com.zk.offer66.from41to50;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Q41FindContinuousSequence {
    /**
     * 第一种思路 O(n^2)
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> solution(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) {
            return result;
        }

        for (int i = 1; i < sum / 2 + 1; i++) {
            for (int j = i + 1; j <= sum / 2 + 1; j++) {
                //等差数列求和公式
                if ((i + j) * (j - i + 1) == 2 * sum) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        temp.add(k);
                    }
                    result.add(temp);
                }
            }
        }
        return result;
    }

    /**
     * //左神的思路，双指针问题
     * //当总和小于sum，大指针继续+
     * //否则小指针+
     */
    public ArrayList<ArrayList<Integer>> solution2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) {
            return result;
        }
        int high = 2;
        int low = 1;
        while (high > low){
            int currentSum = (low + high)*(high-low +1)/2;
            if (currentSum == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = low ;i <= high; i++) {
                    temp.add(i);
                }
                result.add(temp);
                low ++ ;
            }else if (currentSum < sum){
                high++;
            }else {
                low++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Q41FindContinuousSequence q41 = new Q41FindContinuousSequence();
        ArrayList<ArrayList<Integer>> result = q41.solution2(100);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
