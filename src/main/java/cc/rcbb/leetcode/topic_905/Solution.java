package cc.rcbb.leetcode.topic_905;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 905. 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int si = 0;
        int ei = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                result[si++] = nums[i];
            } else {
                result[ei--] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.sortArrayByParity(new int[]{3, 1, 2, 4}));
        RcbbPrinter.print(solution.sortArrayByParity(new int[]{0}));
        RcbbPrinter.print(solution.sortArrayByParity(new int[]{1}));
    }
}