package cc.rcbb.leetcode.topic_440;

/**
 * 440. 字典序的第K小数字
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(12, 4));
        System.out.println(solution.findKthNumber(1, 1));
    }
}