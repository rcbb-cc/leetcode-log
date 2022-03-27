package cc.rcbb.leetcode.topic_2028;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 2028. 找出缺失的观测数据
 * https://leetcode-cn.com/problems/find-missing-observations/
 */
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        int exitSum = 0;
        for (int i = 0; i < m; i++) {
            exitSum += rolls[i];
        }
        int missSum = sum - exitSum;
        if (missSum > 6 * n || missSum < n) {
            return new int[0];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.min(missSum - (n - 1 - i), 6);
            missSum -= result[i];
        }
        return result;
    }

    public int[] missingRolls1(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        int exitSum = 0;
        for (int i = 0; i < m; i++) {
            exitSum += rolls[i];
        }
        int missSum = sum - exitSum;
        if (missSum > 6 * n || missSum < n) {
            return new int[0];
        }
        int q = missSum / n;
        int r = missSum % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = q + (i < r ? 1 : 0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.missingRolls(new int[]{3, 2, 4, 3}, 4, 2));
        RcbbPrinter.print(solution.missingRolls(new int[]{1, 5, 6}, 3, 4));
        RcbbPrinter.print(solution.missingRolls(new int[]{1, 2, 3,4}, 6, 4));

        //[4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5] 4 40
        RcbbPrinter.print(solution.missingRolls(new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40));
    }
}