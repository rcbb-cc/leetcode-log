package cc.rcbb.leetcode.topic_714;

/**
 * 714. 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i1 = Math.max(dp_i1, dp_i0 - price);
            dp_i0 = Math.max(dp_i0, dp_i1 + price - fee);
        }
        return dp_i0;
    }


    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}