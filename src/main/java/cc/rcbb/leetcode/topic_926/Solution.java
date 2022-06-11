package cc.rcbb.leetcode.topic_926;

/**
 * 926. 将字符串翻转到单调递增
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            dp[i][0] = dp[i - 1][0] + (c == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (c == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr("00110"));
        System.out.println(solution.minFlipsMonoIncr("010110"));
        System.out.println(solution.minFlipsMonoIncr("00011000"));
    }
}