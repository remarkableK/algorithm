package com.zk.offer66.from41to50;

/**
 * 约瑟夫环问题
 */
public class Q46LastRemaining {
    /**
     * 求最后剩下的一个人
     * 从0开始  数组模拟链表
     */
    public int solution(int n, int m) {
        //标记已经淘汰的人个数
        int num = 0;
        int[] array = new int[n];
        //标记当前报数的数组下标
        int index = 0;
        //标记当前轮已经报数的人个数
        int times = 0;
        //num 是淘汰的人个数
        while (num < array.length - 1) {
            //0~m-1 第m-1个去除。 先找到前面的m-1个
            while (times < m - 1) {
                //当前元素没有被淘汰
                if (array[index] != -1) {
                    times++;
                }
                index = (index + 1 + n) % n;
            }
            //找到第m个数值为0的元素
            while (array[index] != 0) {
                index = (index + 1 + n) % n;
            }
            //找到应该被淘汰的数字
            num++;
            array[index] = -1;
            times = 0;
            index = (index + 1 + n) % n;
        }
        //挑出最后一个
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q46LastRemaining q46 = new Q46LastRemaining();
        System.out.println(q46.solution(5, 3));
    }

    /**
     * 根据导出的公式f(n,m) = (f(n-1,m)+m)%n来求解
     */
    public int solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        return recursionSolution(n, m);
    }

    private int recursionSolution(int n, int m) {
        //递归的出口
        if (n == 1) {
            return 0;
        }
        return (recursionSolution(n - 1, m) + m) % n;
    }

    /**
     * 和 solution2一样只是将递归改为循环,内存和时间消耗更少点
     */
    public int solution3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        //last = f(n,m) 向后面递推
        int last = 0;
        for (int i = 2; i <= n; i++) {
            //下一轮的f(n,m) = (f(n-1,m)+ m) % n;
            last = (last + m) % i;
        }
        return last;
    }
}
