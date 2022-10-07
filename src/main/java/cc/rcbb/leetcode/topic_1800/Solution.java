package cc.rcbb.leetcode.topic_1800;

/**
 * 1800. 最大升序子数组和
 * https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 */
class Solution {

    public int maxAscendingSum1(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int max = nums[0];
        int index = -1;
        for (int i = 1; i < n; i++) {
            arr[i] = nums[i] + arr[i - 1];
            if (nums[i] <= nums[i - 1]) {
                if (index == -1) {
                    max = Math.max(max, arr[i - 1]);
                } else {
                    max = Math.max(max, arr[i - 1] - arr[index]);
                }
                index = i - 1;
            } else {
                if (index == -1) {
                    max = Math.max(max, arr[i]);
                } else {
                    max = Math.max(max, arr[i] - arr[index]);
                }
            }
        }
        return max;
    }

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max = nums[0], cur = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(solution.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(solution.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(solution.maxAscendingSum(new int[]{100, 10, 1}));
        System.out.println(solution.maxAscendingSum(new int[]{1, 2, 3, 1, 2, 3, 4}));
        System.out.println(solution.maxAscendingSum(new int[]{3, 6, 10, 1, 8, 9, 9, 8, 9}));
        System.out.println(solution.maxAscendingSum(new int[]{5, 5, 6, 6, 6, 9, 1, 2}));
    }
}