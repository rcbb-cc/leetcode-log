package cc.rcbb.leetcode.topic_518;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
class Solution {
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：amount = 5, coins = [1, 2, 5]
        //输出：4
        //解释：有四种方式可以凑成总金额：
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        System.out.println(solution.change(0, new int[]{1, 2, 5}));


        //输入：amount = 3, coins = [2]
        //输出：0
        //解释：只用面额 2 的硬币不能凑成总金额 3 。
        System.out.println(solution.change(3, new int[]{2}));

        //输入：amount = 10, coins = [10]
        //输出：1
        System.out.println(solution.change(10, new int[]{10}));
    }
}