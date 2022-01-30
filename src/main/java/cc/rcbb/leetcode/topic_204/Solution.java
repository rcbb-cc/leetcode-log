package cc.rcbb.leetcode.topic_204;

/**
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 */
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        // for (int i = 2; i < n; i++) {
        // 优化，i无需到n，仅需到sqrt(n)即可
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(0));
        System.out.println(solution.countPrimes(1));

    }
}