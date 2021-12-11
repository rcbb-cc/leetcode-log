package cc.rcbb.leetcode.topic_712;

import java.util.Arrays;

/**
 * 712. 两个字符串的最小ASCII删除和
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int s1Sum = 0;
        for (int i = 0; i < m; i++) {
            s1Sum += s1.charAt(i);
        }
        int s2Sum = 0;
        for (int i = 0; i < n; i++) {
            s2Sum += s2.charAt(i);
        }
        int[][] dp = new int[m + 1][n + 1];
        int sum = s1Sum + s2Sum;
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], sum);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] - (s1.charAt(i - 1) + s2.charAt(j - 1));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: s1 = "sea", s2 = "eat"
        //输出: 231
        System.out.println(solution.minimumDeleteSum("sea","eat"));
        //"delete" "leet" 403
        System.out.println(solution.minimumDeleteSum("delete","leet"));

        String s = "abc";
    }
}