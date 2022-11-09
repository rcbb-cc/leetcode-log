package cc.rcbb.leetcode.topic_764;

import java.util.*;

/**
 * 764. 最大加号标志
 * https://leetcode.cn/problems/largest-plus-sign/
 * <p>
 * 动态规划
 */
class Solution {


    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<>();
        for (int[] mine : mines) {
            banned.add(mine[0] * n + mine[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            // left
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            // right
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            // up
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            // down
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{3, 0}, {3, 3}}));
        System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}}));
        System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        System.out.println(solution.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
    }
}