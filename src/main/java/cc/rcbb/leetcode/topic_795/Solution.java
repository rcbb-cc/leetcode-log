package cc.rcbb.leetcode.topic_795;

/**
 * 795. 区间子数组个数
 * https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 * <p>
 * 模拟
 */
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int count = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                count += last1 - last2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }
}