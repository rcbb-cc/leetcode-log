package cc.rcbb.leetcode.topic_583;

import java.util.Arrays;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], m+n);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] - 2;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
        System.out.println(solution.minDistance("leetcode", "etco"));
    }
}