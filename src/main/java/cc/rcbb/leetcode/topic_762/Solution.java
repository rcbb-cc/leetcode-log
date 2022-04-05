package cc.rcbb.leetcode.topic_762;

/**
 * 762. 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimes(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimeSetBits(6, 10));
        System.out.println(solution.countPrimeSetBits(10, 15));
    }
}