package cc.rcbb.leetcode.topic_509;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
class Solution1 {

    public int fib(int n) {
        // 备忘录初始化
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 已经计算过了，不再重复计算，直接返回
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int r = solution.fib(2);
        System.out.println(r);
        r = solution.fib(3);
        System.out.println(r);

        r = solution.fib(4);
        System.out.println(r);
    }
}