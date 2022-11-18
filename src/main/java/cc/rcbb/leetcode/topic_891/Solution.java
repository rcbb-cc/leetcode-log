package cc.rcbb.leetcode.topic_891;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 * https://leetcode.cn/problems/sum-of-subsequence-widths/
 * <p>
 * 模拟、数学
 */
class Solution {
    public int sumSubseqWidths(int[] nums) {
        final int MOD = 1000000007;
        Arrays.sort(nums);
        long res = 0;
        long x = nums[0], y = 2;
        for (int j = 1; j < nums.length; j++) {
            res = (res + nums[j] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[j]) % MOD;
            y = y * 2 % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumSubseqWidths(new int[]{2, 1, 3}));
        System.out.println(solution.sumSubseqWidths(new int[]{2}));
    }
}