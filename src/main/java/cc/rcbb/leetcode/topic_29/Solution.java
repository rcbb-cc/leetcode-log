package cc.rcbb.leetcode.topic_29;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
            isNeg = true;
        }
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (mul(mid, y) <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long ans = isNeg ? -left : left;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }

    private long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }
            k = k >> 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
    }
}