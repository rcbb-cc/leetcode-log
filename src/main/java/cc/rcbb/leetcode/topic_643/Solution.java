package cc.rcbb.leetcode.topic_643;

/**
 * 643. 子数组最大平均数 I
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 */
class Solution {
    /**
     * 遍历
     */
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int j = k; j < n; j++) {
            sum = sum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}