package cc.rcbb.leetcode.topic_1760;

import java.util.Arrays;

/**
 * 1760. 袋子里最少数目的球
 * https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 * <p>
 * 二分查找
 */
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSize(new int[]{9}, 2));
        System.out.println(solution.minimumSize(new int[]{2, 4, 8, 2}, 4));
    }
}