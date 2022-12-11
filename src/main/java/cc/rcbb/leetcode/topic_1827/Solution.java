package cc.rcbb.leetcode.topic_1827;

/**
 * 1827. 最少操作使数组递增
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 * <p>
 * 模拟
 */
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 1}));
        System.out.println(solution.minOperations(new int[]{1, 5, 2, 4, 1}));
        System.out.println(solution.minOperations(new int[]{8}));
    }
}