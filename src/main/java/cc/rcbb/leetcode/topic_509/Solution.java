package cc.rcbb.leetcode.topic_509;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
class Solution {
    /**
     * 递归，暴力求解，但效率低下
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.fib(2);
        System.out.println(r);
        r = solution.fib(3);
        System.out.println(r);

        r = solution.fib(4);
        System.out.println(r);
    }
}