package cc.rcbb.leetcode.offer.topic_091;

import java.util.Arrays;

/**
 * 剑指 Offer II 091. 粉刷房子
 * https://leetcode.cn/problems/JEj789/
 */
class Solution {
    public int minCost1(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else if (j == 2) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }
        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }

    public int minCost2(int[][] costs) {
        int m = costs.length;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < m; i++) {
            int[] dpNew = new int[3];
            for (int j = 0; j < 3; j++) {
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = dpNew;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    public int minCost(int[][] costs) {
        int m = costs.length;
        int a = costs[0][0], b = costs[0][1], c = costs[0][2];
        for (int i = 1; i < m; i++) {
            int d = Math.min(b, c) + costs[i][0];
            int e = Math.min(a, c) + costs[i][1];
            int f = Math.min(a, b) + costs[i][2];
            a = d;
            b = e;
            c = f;
        }
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(solution.minCost(new int[][]{{7, 6, 2}}));
    }
}