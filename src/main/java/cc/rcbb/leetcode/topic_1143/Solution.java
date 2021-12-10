package cc.rcbb.leetcode.topic_1143;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1, 0, text2, 0);
    }

    public int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            return Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde","ace"));
        System.out.println(solution.longestCommonSubsequence("abc","abc"));
        System.out.println(solution.longestCommonSubsequence("abc","def"));
    }

}