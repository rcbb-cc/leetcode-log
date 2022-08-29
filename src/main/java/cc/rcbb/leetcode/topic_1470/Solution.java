package cc.rcbb.leetcode.topic_1470;

import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * 1470. 重新排列数组
 * https://leetcode.cn/problems/shuffle-the-array/
 */
class Solution {

    public int[] shuffle1(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int left = 0;
        int right = n;
        int index = 0;
        while (index < 2 * n) {
            if (index % 2 == 0) {
                result[index++] = nums[left++];
            } else {
                result[index++] = nums[right++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：nums = [2,5,1,3,4,7], n = 3
        // 输出：[2,3,5,4,1,7]
        // 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
        RcbbPrinter.print(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        // 输入：nums = [1,2,3,4,4,3,2,1], n = 4
        // 输出：[1,4,2,3,3,2,4,1]
        RcbbPrinter.print(solution.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4));
        // 输入：nums = [1,1,2,2], n = 2
        // 输出：[1,2,1,2]
        RcbbPrinter.print(solution.shuffle(new int[]{1, 1, 2, 2}, 2));
    }
}