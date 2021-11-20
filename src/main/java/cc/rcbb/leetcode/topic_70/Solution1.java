package cc.rcbb.leetcode.topic_70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
class Solution1 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int r = solution.climbStairs(45);
        System.out.println(r);
    }
}