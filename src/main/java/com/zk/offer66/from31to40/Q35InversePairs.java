package com.zk.offer66.from31to40;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Q35InversePairs {

    /**
     * 归并排序
     */
    public int solution2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] temp = new int[array.length];
        return inversePairs(array, temp, 0, array.length - 1);
    }

    private int inversePairs(int[] array, int[] temp, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = (left + right) >> 1;
        //左侧的
        int leftCount = inversePairs(array, temp, left, middle) % 1000000007;
        //右侧
        int rightCount = inversePairs(array, temp, middle + 1, right) % 1000000007;
        //统计当前的
        int count = 0;
        //两个指针分别指向两个数组的末尾
        int i = middle;
        int j = right;
        //合并的位置存放元素的
        int copyLocation = right;
        //进行归并排序
        while (i >= left && j > middle) {
            if (array[i] > array[j]) {
                count += j - middle;
                temp[copyLocation--] = array[i--];
                if (count >= 1000000007) {
                    count = count % 1000000007;
                }
            } else {
                temp[copyLocation--] = array[j--];
            }
        }
        //剩余的部分
        for (i = middle; i >= left; i--) {
            temp[copyLocation--] = array[i];
        }
        for (j= right; j > middle; j--) {
            temp[copyLocation--] = array[j];
        }
        System.arraycopy(temp, left, array, left, right - left + 1);
        return (leftCount + rightCount + count) % 1000000007;
    }

}
