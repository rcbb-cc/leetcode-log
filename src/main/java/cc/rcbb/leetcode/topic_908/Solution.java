package cc.rcbb.leetcode.topic_908;

/**
 * 908. 最小差值 I
 * https://leetcode-cn.com/problems/smallest-range-i/
 */
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = 10000;
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int abs = Math.abs(max - min);
        if (abs <= 2 * k) {
            return 0;
        }
        return abs - 2 * k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：nums = [1], k = 0
        // 输出：0
        // 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
        System.out.println(solution.smallestRangeI(new int[1], 0));

        // 输入：nums = [0,10], k = 2
        // 输出：6
        // 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
        System.out.println(solution.smallestRangeI(new int[]{0, 10}, 2));

        // 输入：nums = [1, 3, 6],k = 3
        // 输出：0
        // 解释：将 nums 改为[4, 4, 4]。分数是 max (nums) - min(nums) = 4 - 4 = 0。
        System.out.println(solution.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}