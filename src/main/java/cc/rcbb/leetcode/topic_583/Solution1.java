package cc.rcbb.leetcode.topic_583;


/**
 * 583. 两个字符串的删除操作
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
class Solution1 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int len = longestCommonSubsequence(word1, word2);
        return m - len + n - len;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.minDistance("sea", "eat"));
        System.out.println(solution.minDistance("leetcode", "etco"));
    }
}