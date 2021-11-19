package cc.rcbb.leetcode.topic_509;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
class Solution2 {

    /**
     * dp数组的迭代解法
     */
    public int fib(int n) {
        if (n == 0) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int r = solution.fib(2);
        System.out.println(r);
        r = solution.fib(3);
        System.out.println(r);

        r = solution.fib(4);
        System.out.println(r);
    }
}