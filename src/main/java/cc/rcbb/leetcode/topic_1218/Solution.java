package cc.rcbb.leetcode.topic_1218;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}