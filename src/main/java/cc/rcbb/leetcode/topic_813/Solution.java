package cc.rcbb.leetcode.topic_813;

/**
 * 813. 最大平均值和的分组
 * https://leetcode.cn/problems/largest-sum-of-averages/
 * <p>
 * 动态规划
 */
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = n; i >= j; i--) {
                for (int x = j - 1; x < i; x++) {
                    dp[i] = Math.max(dp[i], dp[x] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(solution.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }
}