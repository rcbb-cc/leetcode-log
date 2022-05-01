package cc.rcbb.leetcode.topic_978;

/**
 * 978. 最长湍流子数组
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
class Solution {
    /**
     * 湍流子数组的意思是：一个增长和降低互相交替的子数组，如果在坐标轴上画出来就是个波浪状数组。
     * <p>
     * dp[i][j]，以位置 i 为结尾，结尾状态为 j 的最长湍流子数组长度。
     * j：（0：上升；1：下降；）
     */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i] > arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}