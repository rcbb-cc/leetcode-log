package cc.rcbb.leetcode.topic_72;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
class Solution2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1,
                                    dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        /*输入：word1 = "horse", word2 = "ros"
        输出：3
        解释：
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')*/
        System.out.println(solution.minDistance("horse", "ros"));
    }
}