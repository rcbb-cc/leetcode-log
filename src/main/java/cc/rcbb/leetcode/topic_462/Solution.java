package cc.rcbb.leetcode.topic_462;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - mid);
        }
        return count;
    }

    /**
     * 第一思路想到的肯定是中位数
     */
    public int minMoves21(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = 0;
        if (n % 2 == 0) {
            mid = (nums[n / 2 - 1] + nums[n / 2]) / 2;
        } else {
            mid = nums[(n - 1) / 2];
        }
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - mid);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves2(new int[]{1, 2, 3}));
        System.out.println(solution.minMoves2(new int[]{1, 2, 9, 10}));
    }
}