package com.zk.offer66.from21to30;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Q28_MoreThanHalfNum {
    /**
     *使用两个变量 ，num标识访问的数字，times标识num出现过的次数，然后变量该数组
     * 遇到和num相同的就times加一 ，不同的就times减一，times == 0且没有到达数组结尾，就换到当前数
     * 主要思想：一个数字如果出现此处超过数组长度的一半，那么它和一个不等于它的数做次数抵消，剩余的仍然会超过剩下数组的一般
     */
    public int solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            //没有到达数组结尾
            if (times < 1 && i != array.length-1) {
                times = 1;
                num = array[i];
            } else {
                if (array[i] == num) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return times > 0 ? num : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,4,2,5,2,3};
        Q28_MoreThanHalfNum q28 = new Q28_MoreThanHalfNum();
        System.out.println(q28.solution(nums));
    }
}
