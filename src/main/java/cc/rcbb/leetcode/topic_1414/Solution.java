package cc.rcbb.leetcode.topic_1414;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
class Solution {
    public int findMinFibonacciNumbers(int k) {
        int len = 46;
        if (k <= 3) {
            return 1;
        }
        int[] arr = new int[len];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < len; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        int sum = k;
        int count = 0;
        for (int i = len - 1; i >= 0; ) {
            if (sum == 0) {
                break;
            }
            if (sum - arr[i] < 0) {
                i--;
                continue;
            } else {
                sum = sum - arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(7));
        System.out.println(solution.findMinFibonacciNumbers(10));
        System.out.println(solution.findMinFibonacciNumbers(19));
        System.out.println(solution.findMinFibonacciNumbers(199));
    }
}