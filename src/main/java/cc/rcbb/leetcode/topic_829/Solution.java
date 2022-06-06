package cc.rcbb.leetcode.topic_829;

/**
 * 829. 连续整数求和
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 */
class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int bound = 2 * n;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isConsecutive(n, k)) {
                count++;
            }
        }
        return count;
    }

    public boolean isConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }
}