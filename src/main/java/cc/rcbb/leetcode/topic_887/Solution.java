package cc.rcbb.leetcode.topic_887;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
class Solution {

    public int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(memo, k, n);
    }

    private int f(int[][] memo, int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[k][n] != -1) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(f(memo, k, n - i), f(memo, k - 1, i - 1)) + 1);
        }
        memo[k][n] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superEggDrop(1, 2));
        System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(3, 14));
    }

}