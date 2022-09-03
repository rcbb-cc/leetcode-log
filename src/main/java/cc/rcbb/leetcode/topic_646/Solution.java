package cc.rcbb.leetcode.topic_646;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        int curr = Integer.MIN_VALUE;
        int res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }

    public int findLongestChain1(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}