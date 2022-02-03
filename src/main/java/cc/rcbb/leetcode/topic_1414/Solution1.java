package cc.rcbb.leetcode.topic_1414;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
class Solution1 {
    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        int a = 1;
        int b = 1;
        while (k > b) {
            int c = a + b;
            a = b;
            b = c;
        }
        while (k != 0) {
            while (k - b >= 0) {
                k = k - b;
                count++;
            }
            int c = b - a;
            b = a;
            a = c;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.findMinFibonacciNumbers(7));
        System.out.println(solution.findMinFibonacciNumbers(10));
        System.out.println(solution.findMinFibonacciNumbers(19));
        System.out.println(solution.findMinFibonacciNumbers(199));
    }
}