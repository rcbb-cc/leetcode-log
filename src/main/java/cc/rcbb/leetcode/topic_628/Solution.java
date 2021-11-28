package cc.rcbb.leetcode.topic_628;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
class Solution {
    /**
     * 首先先排序
     * 原因：需要找到最小的两个值，和最大的三个值
     * 为什么？
     * 1.数值全是正数；（最大的三个值）
     * 2.数值全是负数；（最大的三个值）
     * 3.数值有正有负；（a.找最小的两个负数和最大的正数；b.最大单个值；）对比，a和b这两种情况，哪个值更大
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    /**
     * 线性扫描
     * 找到：需要找到最小的两个值，和最大的三个值
     */
    public int maxMinValue(int[] nums) {
        // 最小的值
        int min1 = Integer.MAX_VALUE;
        // 第二小的值
        int min2 = Integer.MAX_VALUE;
        // 最大的值
        int max1 = Integer.MIN_VALUE;
        // 第二大的值
        int max2 = Integer.MIN_VALUE;
        // 第三大的值
        int max3 = Integer.MIN_VALUE;

        for (int val : nums) {
            if (val < min1) {
                min2 = min1;
                min1 = val;
            } else if (val < min2) {
                min2 = val;
            }

            if (val > max1) {
                max3 = max2;
                max2 = max1;
                max1 = val;
            } else if (val > max2) {
                max3 = max2;
                max2 = val;
            } else if (val > max3) {
                max3 = val;
            }
        }
        //System.out.println("min1=" + min1 + " min2=" + min2 + " max1=" + max1 + " max2=" + max2 + " max3" + max3);
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 仅只有正数
        //int[] nums = new int[]{1,2,3};
        //int[] nums = new int[]{1,2,3,4};
        //int[] nums = new int[]{-1,-2,-3};
        int[] nums = new int[]{-1, -2, -3, 4};
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6};

        int r = solution.maximumProduct(nums);
        System.out.println(r);
        int s = solution.maxMinValue(nums);
        System.out.println(s);

    }
}