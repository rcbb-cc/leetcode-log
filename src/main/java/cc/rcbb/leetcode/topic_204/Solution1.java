package cc.rcbb.leetcode.topic_204;

import java.util.Arrays;
/**
 * 204. 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 */
class Solution1 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // for (int i = 2; i < n; i++) {
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // for (int j = 2 * i; j < n; j += i) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(0));
        System.out.println(solution.countPrimes(1));

    }
}