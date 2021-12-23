package cc.rcbb.leetcode.topic_188;

/**
 * 188. 买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (prices.length <= 0) {
            return 0;
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：k = 2, prices = [2,4,1]
        //输出：2
        //解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1}));

        //输入：k = 2, prices = [3,2,6,5,0,3]
        //输出：7
        //解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
        //随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(solution.maxProfit(2, new int[]{}));
    }
}