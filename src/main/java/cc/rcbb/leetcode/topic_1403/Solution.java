package cc.rcbb.leetcode.topic_1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }
}