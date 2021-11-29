package cc.rcbb.leetcode.topic_441;

/**
 * 441. 排列硬币
 * https://leetcode-cn.com/problems/arranging-coins/
 */
class Solution {
    /**
     * 迭代
     */
    public int arrangeCoins1(int n) {
        if (n == 0) {
            return n;
        }
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法，需注意乘法超范围问题
     */
    public int arrangeCoins2(int n) {
        if (n == 0) {
            return n;
        }
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long val = (mid * (mid + 1)) / 2;
            if (val == n) {
                return (int) mid;
            } else if (val > n) {
                right = mid - 1;
            } else if (val < n) {
                left = mid + 1;
            }
        }
        return (int) left - 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.arrangeCoins(1));
        //System.out.println(solution.arrangeCoins(5));
        //System.out.println(solution.arrangeCoins(8));
    }
}