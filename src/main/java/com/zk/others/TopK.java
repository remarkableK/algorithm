package com.zk.others;

/**
 * campus.ke.com/Portal/Apply/Index
 * 求Topk问题  分为两种
 * 1.TopK Elements 问题用于找出一组数中最大的 K 个的数。
 * 2.此外还有一种叫 Kth Element 问题，用于找出一组数中第 K 大的数
 */
public class TopK {
    /**
     * 针对于第2种求第K大的数字，可以使用快排的partition()方法
     * 快速排序的 partition() 方法，对于数组 nums 的 [l, h] 区间，会返回一个整数 k 使得 nums[l..k-1] 小于等于 nums[k]，
     * 且 nums[k+1..h] 大于等于 nums[k]，此时 nums[k] 就是数组的第 k 大元素。
     * 可以利用这个特性找出数组的 Kth Element，这种找 Kth Element 的算法称为快速选择算法
     * 时间复杂度 O(N)、空间复杂度 O(1)
     * 只有当允许修改数组元素时才可以使用
     */
    public int kthElement(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int t = partition(nums, left, right);
            if (t == k) {
                return nums[k];
            } else if (t > k) {
                right = t - 1;
            } else {
                left = t + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int flag = nums[left];
        while (left < right) {
            while (right > left && nums[right] >= flag) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= flag) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = flag;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,6,4};
        TopK topK = new TopK();
        System.out.println(topK.kthElement(nums,2));
    }
}
