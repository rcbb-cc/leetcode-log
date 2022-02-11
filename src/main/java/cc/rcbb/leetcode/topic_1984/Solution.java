package cc.rcbb.leetcode.topic_1984;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[n - 1];
        int bdry = k - 1;
        for (int i = n - 1; i >= bdry; i--) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDifference(new int[]{9, 4, 1, 7}, 2));
        //[87063,61094,44530,21297,95857,93551,9918]
        //6
        //74560
        //System.out.println(solution.minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
    }
}