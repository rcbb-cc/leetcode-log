package cc.rcbb.leetcode.topic_878;

/**
 * 878. 第 N 个神奇数字
 * https://leetcode.cn/problems/nth-magical-number/
 * <p>
 * 容斥原理、二分查找
 */
class Solution {

    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthMagicalNumber(1, 2, 3));
        System.out.println(solution.nthMagicalNumber(4, 2, 3));
    }
}