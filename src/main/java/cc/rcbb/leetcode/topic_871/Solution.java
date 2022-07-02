package cc.rcbb.leetcode.topic_871;


/**
 * 871. 最低加油次数
 * https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // dp[i] 表示加油 i 次的最大行驶里程
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(1, 1, new int[][]{}));
        System.out.println(solution.minRefuelStops(100, 1, new int[][]{{10, 100}}));
        System.out.println(solution.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }
}