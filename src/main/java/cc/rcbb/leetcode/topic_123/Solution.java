package cc.rcbb.leetcode.topic_123;

/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k_max = 2;
        int[][][] dp = new int[n][k_max + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = k_max; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k_max][0];
    }


    public int maxProfit1(int[] prices) {
        int dp_i10 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            // 状态转移⽅程：
            // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
            // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
            // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
            // dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6
        System.out.println(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

        //输入：prices = [1,2,3,4,5]
        //输出：4
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));

        //输入：prices = [7,6,4,3,1]
        //输出：0
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));

        //输入：prices = [1]
        //输出：0
        System.out.println(solution.maxProfit(new int[]{1}));

    }
}