package cc.rcbb.leetcode.topic_322;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        return dp(coins,amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}