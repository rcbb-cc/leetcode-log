package cc.rcbb.leetcode.topic_300;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [0,1,0,3,2,3]
        //输出：4
        //int[] nums = new int[]{0, 1, 0, 3, 2, 3};

        //输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4
        //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
        int[] nums = new int[]{10,9,2,5,3,7,101,18};

        //输入：nums = [7,7,7,7,7,7,7]
        //输出：1
        //int[] nums = new int[]{7,7,7,7,7,7,7};
        int max = solution.lengthOfLIS(nums);
        System.out.println(max);

    }
}