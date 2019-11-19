package com.zk.offer66.from31to40;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Q37GetNumberOfK {
    /**
     * 初步思路二分查找
     * @param array
     * @param k
     * @return
     */
    public int solution(int[] array,int k){
        int left = 0;
        int right = array.length-1;
        int times = 0;
        while (left <= right){
            int middle = left + (right-left)/2;
            if (array[middle] == k){
                times = 1;
                int leftBegin = middle-1;
                int rightBegin = middle+1;
                while (leftBegin>=0 && array[leftBegin] == k) {
                    times++;
                    leftBegin--;
                }
                while (rightBegin< array.length && array[rightBegin] == k) {
                    times++;
                    rightBegin++;
                }
                return times;
            }else if (array[middle] > k){
                right = middle -1;
            }else {
                left = middle + 1;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3};
        Q37GetNumberOfK q37 = new Q37GetNumberOfK();
        System.out.println(q37.solution(array,3));
    }
}
