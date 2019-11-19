package com.zk.offer66.from41to50;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * 大小王可以充当任何数
 */
public class Q45CardGame {
    /**
     * 根据有没有网分为几种情况
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int numberOfKing = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numberOfKing++;
            }
        }
        return solution(numbers, numberOfKing);
    }
    private boolean solution(int[] array, int numberOfKing) {
        if (numberOfKing == 4) {
            return true;
        }
        if (numberOfKing == 0) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] != (array[i - 1] + 1)) {
                    return false;
                }
            }
            return true;
        }
        //如果有重复肯定是不可能的
        if (containRepeat(array, numberOfKing)) {
            return false;
        }
        //除了大小王的其他数字间距应该小于等于4
        return array[4] - array[numberOfKing] <= 4;
    }
    public boolean containRepeat(int[] array, int index) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 2, 6, 4};
        Q45CardGame q45 = new Q45CardGame();
        System.out.println(q45.isContinuous(array));
    }
}
